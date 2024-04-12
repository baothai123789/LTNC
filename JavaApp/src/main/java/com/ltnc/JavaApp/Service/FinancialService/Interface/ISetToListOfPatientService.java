package com.ltnc.JavaApp.Service.FinancialService.Interface;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Patient;

public interface ISetToListOfPatientService {
    public void setPatientMap(FinancialEmployee financialEmployee, Patient patient, int fee);
}
