package com.example.patient.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Nominee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nomineeId;

    private String name;

    private String email;
}
