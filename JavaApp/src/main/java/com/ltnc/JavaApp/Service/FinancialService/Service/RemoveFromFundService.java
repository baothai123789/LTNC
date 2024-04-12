package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.SalaryOfEmployee;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Repository.SalaryOfEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RemoveFromFundService {

    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;

    @Autowired
    private SalaryOfEmployeeRepository salaryOfEmployeeRepository;

    public void deductSalaryFromFund(String financialEmployeeId, String employeeSalaryId)    {
        Optional<FinancialEmployee> optionalFinancialEmployee = financialEmployeeRepository.findById(financialEmployeeId);
        Optional<SalaryOfEmployee> optionalSalaryOfEmployee = salaryOfEmployeeRepository.findById(employeeSalaryId);

        if (optionalFinancialEmployee.isPresent() && optionalSalaryOfEmployee.isPresent()) {
            FinancialEmployee financialEmployee = optionalFinancialEmployee.get();
            SalaryOfEmployee salaryOfEmployee = optionalSalaryOfEmployee.get();

            long employeeSalary = salaryOfEmployee.getSalaries().getOrDefault(financialEmployeeId, 0);
            financialEmployee.minustoFund(employeeSalary);

            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Financial Employee or Salary not found with provided IDs.");
        }
    }
}
