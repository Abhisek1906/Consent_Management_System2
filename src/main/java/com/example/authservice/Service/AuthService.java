package com.example.authservice.Service;

import com.example.authservice.Dto.AuthenticationRequest;
import com.example.authservice.Dto.AuthenticationResponse;
import com.example.authservice.Repository.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;

    private final DoctorRepo doctorRepo;
    private final JwtService jwtService;

    public AuthenticationResponse authenticateDoctor(AuthenticationRequest authenticationRequest){
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );

        if(authentication.isAuthenticated()){
            var user= doctorRepo.findDoctorCredentialsByName(authenticationRequest.getUsername())
                    .orElseThrow();
            var jwtToken=jwtService.generateToken((UserDetails) user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }else{
            throw new UsernameNotFoundException("invalid user request!");
        }
    }
}
