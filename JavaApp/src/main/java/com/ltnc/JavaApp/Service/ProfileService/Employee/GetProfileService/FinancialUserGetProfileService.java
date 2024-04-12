package com.ltnc.JavaApp.Service.ProfileService.Employee.GetProfileService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialUserGetProfileService extends AbstractGetProfileService<FinancialEmployee> {
    @Autowired
    public FinancialUserGetProfileService(FinancialEmployeeRepository financialEmployeeRepository){
        this.modelRepository = financialEmployeeRepository;
        this.type = FinancialEmployee.class;
    }
}
