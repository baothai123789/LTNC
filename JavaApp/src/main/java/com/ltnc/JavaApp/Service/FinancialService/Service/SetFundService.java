package com.ltnc.JavaApp.Service.FinancialService.Service;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Service.FinancialService.Interface.ISetFundService;
import org.springframework.beans.factory.annotation.Autowired;

public class SetFundService implements ISetFundService {
    @Autowired
    FinancialEmployeeRepository financialEmployeeRepository;

    @Override
    public void setOriginalFund(FinancialEmployee financialEmployee, long fund) {
        financialEmployee.setFund(fund);
        financialEmployeeRepository.save(financialEmployee);
    }
}
