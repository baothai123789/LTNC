package com.ltnc.JavaApp.Service.ProfileService.Employee.EditUserService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialEditUserService extends AbstractEditUserService<FinancialEmployee>{
    @Autowired
    public FinancialEditUserService(FinancialEmployeeRepository financialEmployeeRepository){
        this.modelRepository = financialEmployeeRepository;
        this.type = FinancialEmployee.class;
    }
}
