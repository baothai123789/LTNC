package com.ltnc.JavaApp.Service.FinancialService.Interface;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Patient;

public interface IAddToListOfPatientService {
    public void addPatientToMap(FinancialEmployee financialEmployee, Patient patient, int fee);
}
