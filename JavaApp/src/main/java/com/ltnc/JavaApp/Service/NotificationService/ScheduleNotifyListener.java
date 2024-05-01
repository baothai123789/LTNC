package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.Person;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;


public class ScheduleNotifyListener implements NotifyListener{
    protected Person person;
    @Setter
    NotificationManage notificationManage;
    public ScheduleNotifyListener(Person person){
        this.person = person;
    }
    private boolean checkDetail(Map<String,Object> detail){
        if (!detail.containsKey("scheduleTime")) return false;
        if(!Integer.class.isInstance(detail.get("scheduleTime").getClass())) return false;
        if(!detail.containsKey("scheduleDate")) return false;
        if(!LocalDate.class.isInstance(detail.get("scheduleDate").getClass())) return false;
        if(!detail.containsKey("scheduleId")) return false;
        return String.class.isInstance(detail.get("scheduleId").getClass());
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
}
