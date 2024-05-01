package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.*;
import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotifyMedicalDetailService {
    @Resource
    NotificationManage notificationManage;
    public void sendNotifytoPatient(Patient patient, Schedule schedule,String medicalDetailId){
        Notification notification = new Notification();
        notification.setTitle(schedule.getDetail());
        notification.setBody(
                "Bạn có lịch tái khám của hoá đơn khám bệnh: "+medicalDetailId
                +" vào lúc "+ schedule.getStartTime()+"h vào ngày "+schedule.getDate()
                +". Mã cuộc hẹn của bạn là: "+schedule.getId()
        );
        notification.setDateTime(LocalDateTime.now());
        notificationManage.sendNotification(notification,patient);
    }
    public void sendNotifytoDoctor(Doctor doctor,Schedule schedule,String patientId,String medicalDetailId){
        Notification notification = new Notification();
        notification.setTitle(schedule.getDetail());
        notification.setBody(
                "Bạn có lịch tái khám của bệnh nhân mã số: "+ patientId
                +" của hồ sơ khám bệnh mã số: "+medicalDetailId
                +" vào lúc "+ schedule.getStartTime()
                +"h vào ngày "+ schedule.getDate()
        );
        notification.setDateTime(LocalDateTime.now());
        notificationManage.sendNotification(notification,doctor);
    }
}
