package com.ltnc.JavaApp.Service.FinancialService.Interface;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Model.PharmacyManager;

public interface ISetToListOfEmployeeService {
    public void setDoctorMap(Doctor doctor, int salary);
    public void setNurseMap(Nurse nurse, int salary);
    public void setPharmacyManagerMap(PharmacyManager pharmacyManager,int salary);
}
