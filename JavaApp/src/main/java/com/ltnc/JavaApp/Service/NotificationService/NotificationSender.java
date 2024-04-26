package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.*;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.NotificationRepository;
import com.ltnc.JavaApp.Repository.UserAccountRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Setter
@Service
public class NotificationSender implements INotificationSender{
    @Autowired
    NotificationRepository notificationRepository;



    @Override
    public void sendNotification(Notification notification, Person person) {
        UserAccount userAccount = person.getUserAccount();
        NotificationList notificationList = userAccount.getNotificationList();
        notificationList.getNotifications().add(notification);
        notificationRepository.save(notificationList);
    }



}
