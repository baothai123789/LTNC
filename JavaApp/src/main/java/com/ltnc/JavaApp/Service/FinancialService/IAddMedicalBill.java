package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Service.NotificationService.NotifyObserver;

public interface IAddMedicalBill {
    public void addMedicalBill(MedicalBill medicalBill, FinancialEmployee financialEmployee);
}
