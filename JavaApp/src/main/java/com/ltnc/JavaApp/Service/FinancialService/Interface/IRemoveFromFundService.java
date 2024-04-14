package com.ltnc.JavaApp.Service.FinancialService.Interface;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Model.PharmacyManager;

public interface IRemoveFromFundService {
    void deductDoctorSalaryFromFund(Doctor doctor);
    void deductNurseSalaryFromFund(Nurse nurse);
    void deductPharmacyManagerSalaryFromFund(PharmacyManager pharmacyManager);
}
