package com.example.patient.Repository;

import com.example.patient.Entity.Notification;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {
    Notification getNotificationByConsentId(int consentId);
}
