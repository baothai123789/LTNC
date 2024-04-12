package com.ltnc.JavaApp.Service.FinancialService.Service;

import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveFromFundService  {

    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;



}
