package com.example.patient.Repository;

import com.example.patient.Entity.Notification;
import com.example.patient.Entity.Patient;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {
    Notification getNotificationByConsentId(int consentId);

    Notification getNotificationByNotificationId(int notificationId);

    List<Notification> getNotificationsByPatient(Patient patient);
}
