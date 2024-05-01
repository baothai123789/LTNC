package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.Person;

import java.util.Map;

public interface NotifyListener{
    public void sendNotify(Map<String,Object> detail);
    public void  setNotificationManage(NotificationManage notificationManage);
}
