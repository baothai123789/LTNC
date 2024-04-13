package com.ltnc.JavaApp.Service.FinancialService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Service.FinancialService.Interface.IGetSalaryOfEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetSalaryOfEmployeeService implements IGetSalaryOfEmployeeService {

    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;

    @Override
    public int getDoctorSalary(Doctor doctor) {
        FinancialEmployee financialEmployee = financialEmployeeRepository.findByDoctor(doctor);
        if (financialEmployee != null && financialEmployee.getDoctorIntegerMap().containsKey(doctor)) {
            return financialEmployee.getDoctorIntegerMap().get(doctor);
        }
        throw new RuntimeException("Doctor salary not found for the specified employee");
    }

    @Override
    public int getNurseSalary(Nurse nurse) {
        FinancialEmployee financialEmployee = financialEmployeeRepository.findByNurse(nurse);
        if (financialEmployee != null && financialEmployee.getNurseIntegerMap().containsKey(nurse)) {
            return financialEmployee.getNurseIntegerMap().get(nurse);
        }
        throw new RuntimeException("Nurse salary not found for the specified employee");
    }

    @Override
    public int getPharmacyManagerSalary(PharmacyManager pharmacyManager) {
        FinancialEmployee financialEmployee = financialEmployeeRepository.findByPharmacyManager(pharmacyManager);
        if (financialEmployee != null && financialEmployee.getPharmacyManagerIntegerMap().containsKey(pharmacyManager)) {
            return financialEmployee.getPharmacyManagerIntegerMap().get(pharmacyManager);
        }
        throw new RuntimeException("Pharmacy manager salary not found for the specified employee");
    }
}
