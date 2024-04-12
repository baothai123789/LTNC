package com.ltnc.JavaApp.Service.FinancialService.Service;

import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Service.FinancialService.Interface.IAddToFundInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddToFundService  {
    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;
}
