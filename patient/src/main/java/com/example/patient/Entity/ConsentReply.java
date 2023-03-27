package com.example.patient.Entity;

import com.example.patient.Response.EhrResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConsentReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int replyId;

    private int toDoctorId;
    private int toHospitalId;
    private List<EhrResponse> ehrResponseList;
}
