package com.ltnc.JavaApp.Service.FinancialService.Service;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.FeeOfPatient;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Repository.FeeOfPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddToFundService {

    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;

    @Autowired
    private FeeOfPatientRepository feeOfPatientRepository;

    public void addFeeToFund(String financialEmployeeId, String patientId) {
        Optional<FinancialEmployee> optionalFinancialEmployee = financialEmployeeRepository.findById(financialEmployeeId);
        Optional<FeeOfPatient> optionalFeeOfPatient = feeOfPatientRepository.findById(patientId);

        if (optionalFinancialEmployee.isPresent() && optionalFeeOfPatient.isPresent()) {
            FinancialEmployee financialEmployee = optionalFinancialEmployee.get();
            FeeOfPatient feeOfPatient = optionalFeeOfPatient.get();

            long patientFee = feeOfPatient.getFees().getOrDefault(patientId, 0);
            financialEmployee.addToFund(patientFee);

            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Financial Employee or Fee Of Patient not found with provided IDs.");
        }
    }
}
