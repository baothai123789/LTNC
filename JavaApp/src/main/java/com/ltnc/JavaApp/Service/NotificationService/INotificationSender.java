package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;

public interface INotificationSender {
    void sendNotification(Notification notification);
}
