package com.ltnc.JavaApp.Service.ProfileService.Employee.CreateUserService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import com.ltnc.JavaApp.Service.ProfileService.Employee.CreateUserService.AbstractEmployeeCreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialEmployeeCreateUserService extends AbstractEmployeeCreateUserService<FinancialEmployee> {
    @Autowired
    public FinancialEmployeeCreateUserService(FinancialEmployeeRepository financialEmployeeRepository){
        this.modelRepository=financialEmployeeRepository;
        this.type = FinancialEmployee.class;

    }
}
