package com.example.kims.Service;

import com.example.kims.Entity.ConsentRequest;
import com.example.kims.Entity.EHR;
import com.example.kims.Entity.HospitalPatient;
import com.example.kims.Entity.Status;
//import org.springframework.cloud.openfeign.FeignClient;
import java.util.List;

public interface HospitalPatientService {
    boolean addPatient(HospitalPatient hospitalPatient);

    boolean addEhrForPatient(EHR ehr);

    List<EHR> getEHR(int patient);

    //List<EHR> getConsentResponse(ConsentRequest consentRequest);

    List<EHR> getConsentResponse(int hospitalId, int patientId);

    String generateNotificationInPatient(ConsentRequest consentRequest);

    Status getStatusOfConsentRequest(ConsentRequest consentRequest);

    List<HospitalPatient> getAllPatients(int doctorId);

    // generateConsentRequest(int patientId, int hospitalId, int doctorId);
}
