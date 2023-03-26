package com.example.patient.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;
    private int fromHospitalId;

    private int consentId;
    private int fromDoctorId;
    private String message;
    private Status status;
    private String isEmergency;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="abhaId",nullable = false)
    @JsonBackReference
    private Patient patient;
}
