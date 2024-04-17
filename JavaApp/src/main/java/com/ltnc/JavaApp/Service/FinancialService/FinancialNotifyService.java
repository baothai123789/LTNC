package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import com.mongodb.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FinancialNotifyService {
    @Autowired
    NotificationManage notificationManage;
    public void sendNotifytoPatient(Patient patient, MedicalBill medicalBill, String financialPhone, @Nullable String medicalDetailId){
        Notification notification_patient = new Notification();
        notification_patient.setTitle(medicalBill.getType());
        notification_patient.setDateTime(LocalDateTime.now());
        if(medicalBill.getType().equalsIgnoreCase("hoá đơn thuốc")){
        notification_patient.setBody(
                "Bạn có hoá đơn thuốc mã số "+medicalBill.getId()
                        +" với số tiền cần thanh toán là "+medicalBill.getTotalPay()
                        +". Vui lòng liên hệ qua số điện thoại "+financialPhone
                        +" hoặc đến văn phòng tài chính. Vui lòng thanh toán trước ngày "+medicalBill.getHastopay()
                        +". Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi"
        );}
        else {
            notification_patient.setBody("Bạn có hoá khám bệnh với mã số: "+medicalBill.getId()
                    +"Từ hoá đơn khám bệnh mã số: "+medicalDetailId
                    +" với số tiền cần thanh toán là "+medicalBill.getTotalPay()
                    +". Vui lòng liên hệ qua số điện thoại "+financialPhone
                    +" hoặc đến văn phòng tài chính. Vui lòng thanh toán trước ngày "+medicalBill.getHastopay()
                    +". Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi");
        }
        notificationManage.sendNotification(notification_patient,patient);
    }
    public void sendNotifytoEmployee(FinancialEmployee financialEmployee,MedicalBill medicalBill,String patientId ){
        String notifi ="Bạn có hoá đơn khám bệnh mới của bệnh nhân mã số: " + patientId;
        Notification notification = new Notification(medicalBill.getType(),notifi, LocalDateTime.now());
        notificationManage.sendNotification(notification,financialEmployee);
    }
}
