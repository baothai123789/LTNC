package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.Person;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FinancialNotifyListener implements NotifyListener{
    @Setter
    NotificationManage notificationManage;
    Person person;
    public FinancialNotifyListener(Person person){
        this.person = person;
    }
    private boolean checkDetail(Map<String,Object> detail){
        List<String> fields = new ArrayList<>(List.of("type","medicalBillId","totalPay","hastoPay"));
        for(String field:fields){
            if(!detail.containsKey(field)) return false;
        }
        return true;
    }
    @Override
    public void sendNotify(Map<String, Object> detail) {
        if(!checkDetail(detail)) throw new RuntimeException("detail fail");
        Notification notification = new Notification();
        notification.setTitle((String)detail.get("type"));
        notification.setDateTime(LocalDateTime.now());
        if(((String)detail.get("type")).equalsIgnoreCase("hoá đơn thuốc")){
            notification.setBody(
                    "Bạn có hoá đơn thuốc mã số "+detail.get("medicalBillId")
                            +" với số tiền cần thanh toán là "+detail.get("totalPay")
                            +" Hạn thanh toán vào ngày "+detail.get("hastoPay")
            );}
        else {
            notification.setBody("Bạn có hoá khám bệnh với mã số: "+detail.get("medicalDetailId")
                    +"Từ hoá đơn khám bệnh mã số: "+detail.get("medicalBillId")
                    +" với số tiền cần thanh toán là "+detail.get("hastoPay")
                    +"Hạn thanh toán trước ngày "+detail.get("hastoPay"));
        }
        notificationManage.sendNotification(notification,person);
    }


}
