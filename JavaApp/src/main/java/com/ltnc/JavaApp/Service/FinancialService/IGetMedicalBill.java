package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.MedicalBill;

import java.util.List;

public interface IGetMedicalBill {
    public List<MedicalBill> getMedicalBills(String userid,Boolean paid);
    public List<MedicalBill> getPatientMedicalBill(String patientId);
}
