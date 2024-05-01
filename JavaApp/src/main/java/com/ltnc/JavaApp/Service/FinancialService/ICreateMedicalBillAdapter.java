package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.Patient;

import java.util.Map;

public interface ICreateMedicalBillAdapter {
    void createMedicalBill(Map<String,Object> data, Patient patient);
}
