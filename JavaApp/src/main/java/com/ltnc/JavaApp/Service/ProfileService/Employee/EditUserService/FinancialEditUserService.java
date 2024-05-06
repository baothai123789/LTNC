package com.ltnc.JavaApp.Service.ProfileService.Employee.EditUserService;

import com.ltnc.JavaApp.Model.Employee;
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

    @Override
    public void editUser(String userId, Employee employee) {
        FinancialEmployee financialEmployee_db = ((FinancialEmployeeRepository)this.modelRepository)
                .findById(userId).orElseThrow(()->new NullPointerException("user not found"));
        FinancialEmployee financialEmployee = (FinancialEmployee) employee;
        financialEmployee_db.getMedicalBill().forEach(
                financialEmployee::addMedicalBill
        );
        financialEmployee.setUserAccount(financialEmployee_db.getUserAccount());
        financialEmployee.setAmountofBillPaid(financialEmployee_db.getAmountofBillPaid());
        ((FinancialEmployeeRepository)this.modelRepository).save(financialEmployee);
    }
}
