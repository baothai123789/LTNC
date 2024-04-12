package com.ltnc.JavaApp.Service.FinancialService.Interface;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Model.PharmacyManager;

public interface ISetToListOfEmployeeService {
    public void setDoctorMap(FinancialEmployee financialEmployee, Doctor doctor, int salary);
    public void setNurseMap(FinancialEmployee financialEmployee, Nurse nurse, int salary);
    public void setPharmacyManagerMap(FinancialEmployee financialEmployee, PharmacyManager pharmacyManager,int salary);
}
