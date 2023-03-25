package com.example.kims.Service;

import com.example.kims.Entity.EHR;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="cms",url = "http://localhost:8081/cms")
public interface CMS_Client {
    @GetMapping("/getConsentResponse")
    List<EHR> getEhrResponse(int hospitalId, int patientId);


}