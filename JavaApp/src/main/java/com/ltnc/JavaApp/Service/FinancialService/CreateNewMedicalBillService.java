package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class CreateNewMedicalBillService {
    @Autowired
    MedicalBillManage medicalBillManage;
    @Autowired
    NotificationManage notificationManage;
    void sendNotification(FinancialEmployee financialEmployee){
        String notifi =" Ban co hoa don moi tu hoa don kham benh ma:" ;
        Notification notification = new Notification("Hoa don moi",notifi, LocalDateTime.now());
        notificationManage.sendNotification(notification,financialEmployee.getNotificationList());
    }
    public void createNewMedicalBill(MedicalBill medicalBill){
        for(Map<String,Object> precistion:medicalBill.getPrescription()){
            precistion.put("inInventory",true);
        }
        FinancialEmployee employee = medicalBillManage.addMedicalBill(medicalBill);
        sendNotification(employee);
    }
}
