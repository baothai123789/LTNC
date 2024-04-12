package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.NotificationList;
import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Repository.NotificationRepository;
import com.ltnc.JavaApp.Service.ProfileService.Employee.IEmployeeProfileMangeService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.CreateUSerService.IPatientCreateUserService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.IPatientProfileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationSender implements INotificationSender {
    @Autowired
    NotificationRepository notificationRepository;
    @Override
    public void sendNotification(Notification notification) {
        NotificationList notificationList = notificationRepository.findById(notification.getPerson().getNotifications().getId()).orElseThrow(NullPointerException::new);
        notificationList.getNotifications().add(notification);
        notificationRepository.save(notificationList);
    }
}
