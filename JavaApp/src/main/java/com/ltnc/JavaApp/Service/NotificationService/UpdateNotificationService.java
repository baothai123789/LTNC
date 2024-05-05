package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.NotificationList;
import com.ltnc.JavaApp.Repository.NotificationRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UpdateNotificationService implements IUpdateNotification{
    @Resource
    NotificationRepository notificationRepository;
    @Override
    public void updateNotifications(NotificationList notificationList) {
        notificationRepository.save(notificationList);
    }
}
