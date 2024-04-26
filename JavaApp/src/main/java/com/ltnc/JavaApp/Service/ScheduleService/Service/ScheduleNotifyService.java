package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduleNotifyService {
    @Resource
    private NotificationManage notificationManage;
    public void sendNotifytoDoctor(Doctor doctor, String patientId, Schedule schedule){
        Notification notification = new Notification();
        notification.setBody("Bạn có lịch khám bệnh từ bệnh nhân: "+patientId+
                " vào lúc "+schedule.getStartTime()+"h ngày "+schedule.getDate());
        notification.setTitle("Lịch khám bệnh");
        notification.setDateTime(LocalDateTime.now());

        notificationManage.sendNotification(notification,doctor);
    }
    public void sendNotifyPatient(Patient patient, Schedule schedule){
        Notification notification_patient = new Notification();
        notification_patient.setBody(
                "Bạn có lịch khám bệnh vào lúc"+schedule.getStartTime()
                        +" ngày "+schedule.getDate()+
                        ". Mã lịch hẹn:"+ schedule.getId()
        );
        notification_patient.setTitle("Lịch Khám Bệnh");
        notification_patient.setDateTime(LocalDateTime.now());
        notificationManage.sendNotification(notification_patient,patient);
    }
}
