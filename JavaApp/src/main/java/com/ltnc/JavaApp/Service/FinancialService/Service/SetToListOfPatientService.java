package com.ltnc.JavaApp.Service.FinancialService.Service;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Service.FinancialService.Interface.ISetToListOfPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetToListOfPatientService implements ISetToListOfPatientService {

    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;

    @Override
    public void setPatientMap(FinancialEmployee financialEmployee, Patient patient, int fee) {
        if (financialEmployee.getPatientIntegerMap().containsKey(patient)) {
            financialEmployee.getPatientIntegerMap().put(patient, fee);
            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Patient not found in the list");
        }
    }
}
