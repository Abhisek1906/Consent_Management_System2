package com.example.kims.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    private int hospitalId;

    private String name;

    private String address;
    private String email;
    private String gender;

    @OneToMany(mappedBy = "doctor")
    @JsonManagedReference
    private List<ConsentRequest> ConsentRequestList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Doctor_Patient_Mapping",
            joinColumns = {
                    @JoinColumn(name = "doctorId", referencedColumnName = "doctorId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "patientId", referencedColumnName = "patientId")
            }
    )
    @JsonManagedReference
    private List<HospitalPatient> hospitalPatientList;

}
