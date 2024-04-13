package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.NotificationList;
import com.ltnc.JavaApp.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationSender implements INotificationSender {
    @Autowired
    NotificationRepository notificationRepository;
    @Override
    public void sendNotification(Notification notification,NotificationList notificationList) {
        notificationList.getNotifications().add(notification);
        notificationRepository.save(notificationList);
    }
}
