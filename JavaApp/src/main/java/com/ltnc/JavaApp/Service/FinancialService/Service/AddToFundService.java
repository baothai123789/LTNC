package com.ltnc.JavaApp.Service.FinancialService.Service;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Service.FinancialService.Interface.IAddToFundInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddToFundService implements IAddToFundInterface {
    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;

    @Override
    public void addFeeToFund(FinancialEmployee financialEmployee,Patient patient) {
        if (financialEmployee.getPatientIntegerMap().containsKey(patient)) {
            int fee = financialEmployee.getPatientFee(patient);
            financialEmployee.addToFund(fee);
            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Patient not found in the list");
        }
    }
}
