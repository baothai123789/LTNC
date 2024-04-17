package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.NotificationList;
import com.ltnc.JavaApp.Model.Person;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationManage implements INotificationManage{
    @Autowired
    INotificationGetter notificationGetter;
    @Autowired
    INotificationSender notificationSender;
    @Autowired
    ICreateNotificationList createNotificationList;
    @Override
    public void sendNotification(Notification notification,Person userid) {
        this.notificationSender.sendNotification(notification,userid);
    }

    @Override
    public List<Notification> getNotifications(String userid) {
        return this.notificationGetter.getNotifications(userid);
    }

    @Override
    public void createNotifications(NotificationList notifications) {
        this.createNotificationList.createNotificationList(notifications);
    }
}
