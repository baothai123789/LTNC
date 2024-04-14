package com.ltnc.JavaApp.Service.FinancialService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Service.FinancialService.Interface.IAddToListOfEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddToListOfEmployeeService implements IAddToListOfEmployeeService {
    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;

    @Override
    public void addDoctorToMap(FinancialEmployee financialEmployee, Doctor doctor) {
        financialEmployee.getDoctorIntegerMap().put(doctor, 0);
        financialEmployeeRepository.save(financialEmployee);
    }

    @Override
    public void addNurseToMap(FinancialEmployee financialEmployee, Nurse nurse) {
        financialEmployee.getNurseIntegerMap().put(nurse, 0);
        financialEmployeeRepository.save(financialEmployee);
    }

    @Override
    public void addPharmacyManagerToMap(FinancialEmployee financialEmployee, PharmacyManager pharmacyManager) {
        financialEmployee.getPharmacyManagerIntegerMap().put(pharmacyManager,0);
        financialEmployeeRepository.save(financialEmployee);
    }
}
