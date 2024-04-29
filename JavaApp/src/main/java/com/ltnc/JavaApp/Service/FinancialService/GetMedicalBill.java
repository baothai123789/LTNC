package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Repository.MedicalBillRepository;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMedicalBill implements IGetMedicalBill {
    @Autowired
    private EmployeeProfileManageService employeeProfileManageService;

    @Override
    public List<MedicalBill> getMedicalBills(String userid, Boolean paid) {

        FinancialEmployee financialEmployee = (FinancialEmployee) employeeProfileManageService.getEmployeeProfile(userid,"financialemployee");
        return financialEmployee.getMedicalBill().stream().filter(medicalBill -> medicalBill.getPaid()==paid).toList();
    }
}
