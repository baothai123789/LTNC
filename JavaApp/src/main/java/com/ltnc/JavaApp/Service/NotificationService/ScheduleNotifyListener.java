package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.Person;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;


public class ScheduleNotifyListener implements NotifyListener{
    @Getter
    protected Person person;
    @Setter
    NotificationManage notificationManage;
    public ScheduleNotifyListener(Person person){
        this.person = person;
    }
    private boolean checkDetail(Map<String,Object> detail){
        if (!detail.containsKey("scheduleTime")) return false;
        if(!detail.containsKey("scheduleDate")) return false;
        return detail.containsKey("scheduleId");
    }
    @Override
    public void sendNotify(Map<String,Object> detail){
        if(!checkDetail(detail)) throw new RuntimeException("detail false");
        Notification notification = new Notification();
        notification.setDateTime(LocalDateTime.now());
        notification.setTitle("Lịch khám bệnh");
        notification.setBody("Bạn có lịch khám bệnh vào lúc: "+detail.get("scheduleTime")+
                " ngày "+detail.get("scheduleDate")+"."+
                "Mã lịch hẹn là: "+detail.get("scheduleId")+".");
        notificationManage.sendNotification(notification,person);
    }

    @Override
    public void sendNotify(Notification notification) {
        notificationManage.sendNotification(notification,person);
    }
}
