package com.example.kims.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Hospital_patient")
@Data
public class HospitalPatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patientId;

    @Column(name="hospital_id",nullable = false)
    private int hospitalId;



    @OneToMany(mappedBy = "patient")
    @JsonManagedReference
    private List<EHR> ehrList;


    @ManyToMany(mappedBy = "hospitalPatientList",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Doctor> doctors;

}
