package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddToFundService {
    @Autowired
    private FinancialEmployeeRepository repository;
}
