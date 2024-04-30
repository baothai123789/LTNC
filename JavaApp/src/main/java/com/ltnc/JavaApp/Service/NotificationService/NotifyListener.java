package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.Person;

public interface NotifyListener{
    public void sendNotify(Notification notification);
    public void  setNotificationManage(NotificationManage notificationManage);
}
