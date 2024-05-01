package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Repository.MedicalBillRepository;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMedicalBillService implements IGetMedicalBill {
    @Resource
    private EmployeeProfileManageService employeeProfileManageService;
    @Resource
    private MedicalBillRepository medicalBillRepository;

    @Override
    public List<MedicalBill> getMedicalBills(String userid, Boolean paid) {

        FinancialEmployee financialEmployee = (FinancialEmployee) employeeProfileManageService.getEmployeeProfile(userid,"financialemployee");
        return financialEmployee.getMedicalBill().stream().filter(medicalBill -> medicalBill.getPaid()==paid).toList();
    }
    public List<MedicalBill> getPatientMedicalBill(String patientId){
        return medicalBillRepository.findPatientMedicalBill(patientId);
    }
}
