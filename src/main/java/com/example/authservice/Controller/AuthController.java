package com.example.authservice.Controller;

import com.example.authservice.Dto.AuthenticationRequest;
import com.example.authservice.Dto.AuthenticationResponse;
import com.example.authservice.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @PostMapping("/authenticateDoctor")
    public ResponseEntity<AuthenticationResponse> authenticateDoctor(
            @RequestBody AuthenticationRequest request
    ){

        return ResponseEntity.ok(authService.authenticateDoctor(request));
    }
}
