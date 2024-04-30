package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;

public interface INotifyObserver {
    public void addListener(String type,NotifyListener notifyListener);
    public void notifyListener(String type, Notification notification);
    public void removeListener(String type,NotifyListener notifyListener);
}
