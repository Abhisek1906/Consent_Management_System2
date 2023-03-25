package com.example.kims.Service;

import com.example.kims.Entity.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "patient",url = "http://localhost:7070/v1/patient")
public interface PatientClient {

    @PostMapping("/generateNotification")
    String generateNotification(int hospitalId, int doctorId, String message, Status status, String isEmergency);


}
