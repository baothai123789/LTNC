package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindFinancialEmployeeService {
    @Autowired
    FinancialEmployeeRepository financialEmployeeRepository;
    public Optional<FinancialEmployee> findEmployee(){
        return financialEmployeeRepository.findFinancialEmployeeValid().orElseThrow(NullPointerException::new).stream().findFirst();
    }

}
