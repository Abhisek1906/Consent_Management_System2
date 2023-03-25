package com.example.patient.Service;

import com.example.patient.Entity.Notification;
import com.example.patient.Entity.Patient;
import com.example.patient.Repository.NotificationRepository;
import com.example.patient.Repository.PatientRepository;
import com.example.patient.Response.EhrResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private NotificationRepository notificationRepository;
@Autowired
private GetEHRfeign ehrList;
    @Override
    public boolean addPatient(Patient patient){
        Patient temp=patientRepository.save(patient);
        if(temp==null)
            return false;
        return true;
    }

    @Override
    public Patient getPatientInfo(int id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public List<EhrResponse> getEhr(int abhaId)
    {
        return ehrList.getEHR(abhaId);
    }

    @Override
    public String sendNotification(Notification notification) {
        Notification notification1=notificationRepository.save(notification);
        if(notification1==null)
            return "Unable to send notification";
        return "Notification send successfully";
    }


}
