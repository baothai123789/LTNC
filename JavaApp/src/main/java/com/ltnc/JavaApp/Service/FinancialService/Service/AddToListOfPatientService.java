package com.ltnc.JavaApp.Service.FinancialService.Service;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Service.FinancialService.Interface.IAddToListOfPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddToListOfPatientService implements IAddToListOfPatientService {

    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;

    @Override
    public void addPatientToMap(FinancialEmployee financialEmployee, Patient patient, int fee) {
        financialEmployee.getPatientIntegerMap().put(patient, fee);
        financialEmployeeRepository.save(financialEmployee);
    }
}
