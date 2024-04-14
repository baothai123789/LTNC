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
    public void deductDoctorSalaryFromFund(Doctor doctor) {
        FinancialEmployee financialEmployee = financialEmployeeRepository.findByDoctor(doctor);
        if (financialEmployee != null && financialEmployee.getDoctorIntegerMap().containsKey(doctor)) {
            int salary = financialEmployee.getDoctorIntegerMap().get(doctor);
            long curFund = financialEmployee.getFund();
            financialEmployee.setFund(curFund - salary);
            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Doctor not found in the list of Financial Employee");
        }
    }

    @Override
    public void deductNurseSalaryFromFund(Nurse nurse) {
        FinancialEmployee financialEmployee = financialEmployeeRepository.findByNurse(nurse);
        if (financialEmployee != null && financialEmployee.getNurseIntegerMap().containsKey(nurse)) {
            int salary = financialEmployee.getNurseIntegerMap().get(nurse);
            long curFund = financialEmployee.getFund();
            financialEmployee.setFund(curFund - salary);
            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Nurse not found in the list of Financial Employee");
        }
    }

    @Override
    public void deductPharmacyManagerSalaryFromFund(PharmacyManager pharmacyManager) {
        FinancialEmployee financialEmployee = financialEmployeeRepository.findByPharmacyManager(pharmacyManager);
        if (financialEmployee != null && financialEmployee.getPharmacyManagerIntegerMap().containsKey(pharmacyManager)) {
            int salary = financialEmployee.getPharmacyManagerIntegerMap().get(pharmacyManager);
            long curFund = financialEmployee.getFund();
            financialEmployee.setFund(curFund - salary);
            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Pharmacy Manager not found in the list of Financial Employee");
        }
    }
}
