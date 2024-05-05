package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.NotificationList;
import com.ltnc.JavaApp.Model.Person;

import java.util.List;

public interface INotificationManage {
    public void sendNotification(Notification notification,Person person);
    public List<Notification> getNotifications(String username);
    public void createNotifications(NotificationList notifications);
    public void setRead(String username);
}
