package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.Person;

import java.util.List;

public interface INotificationGetter{
    public List<Notification> getNotifications(Person user);
}
