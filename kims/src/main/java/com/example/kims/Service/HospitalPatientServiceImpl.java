package com.example.kims.Service;

import com.example.kims.Entity.ConsentRequest;
import com.example.kims.Entity.EHR;
import com.example.kims.Entity.HospitalPatient;
import com.example.kims.Entity.Status;
import com.example.kims.Repository.DoctorRepository;
import com.example.kims.Repository.EhrRepository;
import com.example.kims.Repository.HospitalPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalPatientServiceImpl implements HospitalPatientService{
    @Autowired
    private HospitalPatientRepository hospitalPatientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private EhrRepository ehrRepository;

    @Autowired
    private CMS_Client cmsClient;

    @Autowired
    private PatientClient patientClient;


    @Override
    public boolean addPatient(HospitalPatient hospitalPatient) {
        HospitalPatient temp=hospitalPatientRepository.save(hospitalPatient);
        if(temp==null)
            return false;
        else
            return true;
    }

    @Override
    public boolean addEhrForPatient(EHR ehr) {
        EHR temp=ehrRepository.save(ehr);
        if(temp==null)
            return false;
        return true;
    }
    @Override
    public List<EHR> getEHR(int patientId){
        return hospitalPatientRepository
                .findById(patientId)
                .get()
                .getEhrList();
    }

    @Override
    public List<EHR> getConsentResponse(int hospitalId, int patientId) {
        return cmsClient.getEhrResponse(hospitalId,patientId);
    }

    @Override
    public String generateNotificationInPatient(ConsentRequest consentRequest) {
        return patientClient.generateNotification(consentRequest.getHospitalId(),
                consentRequest.getDoctor().getDoctorId(),consentRequest.getMessage(),consentRequest.getStatus(),
                consentRequest.getIsEmergency());
    }

    @Override
    public Status getStatusOfConsentRequest(ConsentRequest consentRequest) {
        return patientClient.checkStatus(consentRequest.getConsentId());
    }

    @Override
    public List<HospitalPatient> getAllPatients(int doctorId) {
        return doctorRepository.findDoctorByDoctorId(doctorId).getHospitalPatientList();
    }


}
