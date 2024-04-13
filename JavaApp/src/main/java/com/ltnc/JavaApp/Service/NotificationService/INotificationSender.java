package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.NotificationList;

public interface INotificationSender {
    void sendNotification(Notification notification,NotificationList notificationList);
}
