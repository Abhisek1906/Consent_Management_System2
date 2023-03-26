package com.example.patient.Service;

import com.example.patient.Entity.Notification;
import com.example.patient.Entity.Patient;
import com.example.patient.Entity.Status;
import com.example.patient.Response.EhrResponse;

import java.util.List;

public interface PatientService {
    boolean  addPatient(Patient patient);
    Patient getPatientInfo(int id);
    List<EhrResponse> getEhr(int abhaId);

    String sendNotification(Notification notification);

    Status checkStatusofNotification(int consentId);

    Status approveNotification(int notificationId);

    Status rejectNotification(int notificationId);
}
