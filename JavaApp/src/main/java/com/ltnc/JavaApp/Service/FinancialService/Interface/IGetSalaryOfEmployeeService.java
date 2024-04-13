package com.ltnc.JavaApp.Service.FinancialService.Interface;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Model.PharmacyManager;

public interface IGetSalaryOfEmployeeService {
    int getDoctorSalary(Doctor doctor);
    int getNurseSalary(Nurse nurse);
    int getPharmacyManagerSalary(PharmacyManager pharmacyManager);
}
