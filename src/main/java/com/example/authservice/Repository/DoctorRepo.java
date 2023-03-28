package com.example.authservice.Repository;

import com.example.authservice.Entity.DoctorCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepo extends JpaRepository<DoctorCredentials,Integer> {

    Optional<DoctorCredentials> findDoctorCredentialsByName(String username);
}
