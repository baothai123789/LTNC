package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.MyApp;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotifyObserver implements INotifyObserver{
    @Resource
    NotificationManage notificationManage;

    Map<String,List<NotifyListener>> listener=new HashMap<>();
    @Override
    public void addListener(String type, NotifyListener notifyListener) {
        if(!listener.containsKey(type)){
            listener.put(type,new ArrayList<>());
        }
        notifyListener.setNotificationManage(notificationManage);
        listener.get(type).add(notifyListener);
    }
    @Override
    public void notifyListener(String type, Map<String,Object> detail) {
        if(!listener.containsKey(type)) throw  new NullPointerException("not found notify");
        for(NotifyListener notifyListener:listener.get(type)){
            notifyListener.sendNotify(detail);
        }
    }
    @Override
    public void removeListener(String type, NotifyListener notifyListener) {
        listener.get(type).remove(notifyListener);
    }

}
