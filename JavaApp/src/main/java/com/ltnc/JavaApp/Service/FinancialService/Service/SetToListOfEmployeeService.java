package com.ltnc.JavaApp.Service.FinancialService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Service.FinancialService.Interface.ISetToListOfEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetToListOfEmployeeService implements ISetToListOfEmployeeService {

    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;

    @Override
    public void setDoctorMap(Doctor doctor, int salary) {
        FinancialEmployee financialEmployee = financialEmployeeRepository.findByDoctor(doctor);
        if (financialEmployee != null && financialEmployee.getDoctorIntegerMap().containsKey(doctor)) {
            financialEmployee.getDoctorIntegerMap().put(doctor, salary);
            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Doctor not found in the list");
        }
    }

    @Override
    public void setNurseMap(Nurse nurse, int salary) {
        FinancialEmployee financialEmployee = financialEmployeeRepository.findByNurse(nurse);
        if (financialEmployee != null && financialEmployee.getNurseIntegerMap().containsKey(nurse)) {
            financialEmployee.getNurseIntegerMap().put(nurse, salary);
            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Nurse not found in the list");
        }
    }

    @Override
    public void setPharmacyManagerMap(PharmacyManager pharmacyManager, int salary) {
        FinancialEmployee financialEmployee = financialEmployeeRepository.findByPharmacyManager(pharmacyManager);
        if (financialEmployee != null&& financialEmployee.getPharmacyManagerIntegerMap().containsKey(pharmacyManager)) {
            financialEmployee.getPharmacyManagerIntegerMap().put(pharmacyManager, salary);
            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Pharmacy Manager not found in the list");
        }
    }
}
