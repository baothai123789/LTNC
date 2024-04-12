package com.ltnc.JavaApp.Service.FinancialService.Interface;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Model.PharmacyManager;

public interface IAddToListOfEmployeeService {
    public void addDoctorToMap(FinancialEmployee financialEmployee, Doctor doctor);
    public void addNurseToMap(FinancialEmployee financialEmployee, Nurse nurse);
    public void addPharmacyManagerToMap(FinancialEmployee financialEmployee, PharmacyManager pharmacyManager);
}
