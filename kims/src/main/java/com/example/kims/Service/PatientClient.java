package com.example.kims.Service;

import com.example.kims.Entity.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "patient",url = "http://localhost:7070/v1/patient")
public interface PatientClient {

    @PostMapping("/generateNotification/{hospitalId}/{doctorId}/{message}/{status}/{isEmergency}")
    String generateNotification(@PathVariable("hospitalId") int hospitalId,
                                @PathVariable("doctorId") int doctorId,
                                @PathVariable("message")String message,
                                @PathVariable("status")Status status,
                                @PathVariable("isEmergency")String isEmergency);


    @GetMapping("/checkStatus/{consentId}")
    Status checkStatus(@PathVariable("consentId") int consentId);
}
