package com.ltnc.JavaApp.Service.FinancialService.Service;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Service.FinancialService.Interface.IGetTotalFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetTotalFundService implements IGetTotalFundService {

    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;

    @Override
    public long getTotalFund() {
        long totalFund = 0;
        Iterable<FinancialEmployee> financialEmployees = financialEmployeeRepository.findAll();
        for (FinancialEmployee financialEmployee : financialEmployees) {
            totalFund += financialEmployee.getFund();
        }
        return totalFund;
    }
}
