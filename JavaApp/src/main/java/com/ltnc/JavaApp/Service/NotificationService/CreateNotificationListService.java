package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.NotificationList;
import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateNotificationListService implements ICreateNotificationList {
    @Autowired
    NotificationRepository notificationRepository;
    @Override
    public void createNotificationList(NotificationList notificationList) {
        notificationRepository.save(notificationList);
    }
}
