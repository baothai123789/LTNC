package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.NotificationList;
import com.ltnc.JavaApp.Model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface INotificationSender{
    void sendNotification(Notification notification,Person person);
}
