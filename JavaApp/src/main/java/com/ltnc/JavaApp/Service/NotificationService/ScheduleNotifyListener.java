package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.Person;
import lombok.Setter;


public class ScheduleNotifyListener implements NotifyListener{
    protected Person person;
    @Setter
    NotificationManage notificationManage;
    public ScheduleNotifyListener(Person person){
        this.person = person;
    }
    @Override
    public void sendNotify(Notification notification) {
        notificationManage.sendNotification(notification,person);
    }
}
