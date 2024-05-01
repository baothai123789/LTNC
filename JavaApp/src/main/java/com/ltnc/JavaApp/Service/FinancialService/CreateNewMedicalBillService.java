package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.*;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Service.NotificationService.FinancialNotifyListener;
import com.ltnc.JavaApp.Service.NotificationService.NotifyListener;
import com.ltnc.JavaApp.Service.NotificationService.NotifyObserver;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;


@Service
public class CreateNewMedicalBillService {
    @Resource
    NotifyObserver notifyObserver;
    @Resource
    FindFinancialEmployeeService findFinancialEmployeeService;
    @Resource
    MedicalBillManage medicalBillManage;
    @Resource
    EmployeeProfileManageService employeeProfileManageService;

    private void sendNotify(MedicalBill medicalBill,Patient patient,FinancialEmployee financialEmployee){
        Map<String,Object> detail = new HashMap<>(Map.of(
                "medicalBillId",medicalBill.getId(),
                "totalPay",medicalBill.getTotalPay(),
                "hastoPay",medicalBill.getHastopay(),
                "type",medicalBill.getType()
        ));
        MyApp.LOGGER.info(notifyObserver.getListener());
        notifyObserver.notifyListener("financial",detail);
        notifyObserver.clearListener("financial");

    }
    public void createNewMedicalBill(MedicalBill medicalBill,Patient patient) throws NullPointerException{
        MyApp.LOGGER.info(medicalBill.getId());
        MyApp.LOGGER.info(medicalBill.getTotalPay());
        MyApp.LOGGER.info(medicalBill.getHastopay());
        MyApp.LOGGER.info(medicalBill.getType());
        FinancialEmployee financialEmployee = findFinancialEmployeeService.findEmployee().orElseThrow(()->new NullPointerException("cannot find financial employee"));
        medicalBillManage.addMedicalBill(medicalBill,financialEmployee);
        employeeProfileManageService.UpdateUserProfile(financialEmployee);
        sendNotify(medicalBill,patient,financialEmployee);

    }
}
