package com.ltnc.JavaApp.Service.FinancialService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Service.FinancialService.Interface.IRemoveFromFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveFromFundService implements IRemoveFromFundService {

    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;

    @Override
    public void deductDoctorSalaryFromFund(FinancialEmployee financialEmployee, Doctor doctor) {
        if (financialEmployee.getDoctorIntegerMap().containsKey(doctor)) {
            int doctorSalary = financialEmployee.getDoctorIntegerMap().get(doctor);
            financialEmployee.minusFromFund(doctorSalary);
            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Doctor not found in the list of Financial Employee");
        }
    }

    @Override
    public void deductNurseSalaryFromFund(FinancialEmployee financialEmployee, Nurse nurse) {
        if (financialEmployee.getNurseIntegerMap().containsKey(nurse)) {
            int nurseSalary = financialEmployee.getNurseIntegerMap().get(nurse);
            financialEmployee.minusFromFund(nurseSalary);
            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Nurse not found in the list of Financial Employee");
        }
    }

    @Override
    public void deductPharmacyManagerSalaryFromFund(FinancialEmployee financialEmployee, PharmacyManager pharmacyManager) {
        if (financialEmployee.getPharmacyManagerIntegerMap().containsKey(pharmacyManager)) {
            int pharmacyManagerSalary = financialEmployee.getPharmacyManagerIntegerMap().get(pharmacyManager);
            financialEmployee.minusFromFund(pharmacyManagerSalary);
            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Pharmacy Manager not found in the list of Financial Employee");
        }
    }
}
