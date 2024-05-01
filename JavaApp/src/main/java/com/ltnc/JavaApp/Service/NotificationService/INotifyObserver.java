package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;

import java.util.List;
import java.util.Map;

public interface INotifyObserver {
    public void addListener(String type,NotifyListener notifyListener);
    public void notifyListener(String type, Map<String,Object> detail);
    public void removeListener(String type,NotifyListener notifyListener);
    public void clearListener(String type);
    public Map<String,List<NotifyListener>> getListener();
}
