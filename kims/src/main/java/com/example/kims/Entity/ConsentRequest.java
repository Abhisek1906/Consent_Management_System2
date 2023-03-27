package com.example.kims.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ConsentRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int consentId;

    private int hospitalId;
    private int patientId;
    private String message;
    @Enumerated(EnumType.STRING)
    private Status status;

    private String isEmergency;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="doctorId",nullable = false)
    @JsonBackReference
    private Doctor doctor;

}
