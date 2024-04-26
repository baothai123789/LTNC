package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;

public interface IAddMedicalBill {
    public void addMedicalBill(MedicalBill medicalBill,FinancialEmployee financialEmployee);
}
