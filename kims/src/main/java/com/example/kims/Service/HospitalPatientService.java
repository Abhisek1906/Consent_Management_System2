package com.example.kims.Service;

import com.example.kims.Entity.ConsentRequest;
import com.example.kims.Entity.EHR;
import com.example.kims.Entity.HospitalPatient;
//import org.springframework.cloud.openfeign.FeignClient;
import java.util.List;

public interface HospitalPatientService {
    boolean addPatient(HospitalPatient hospitalPatient);

    boolean addEhrForPatient(EHR ehr);

    List<EHR> getEHR(int patient);

    //List<EHR> getConsentResponse(ConsentRequest consentRequest);

    List<EHR> getConsentResponse(int hospitalId, int patientId);

    String generateNotificationInPatient(ConsentRequest consentRequest);

    // generateConsentRequest(int patientId, int hospitalId, int doctorId);
}
