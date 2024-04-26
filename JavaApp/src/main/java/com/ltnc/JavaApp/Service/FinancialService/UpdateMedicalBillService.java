package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Repository.MedicalBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateMedicalBillService implements IUpdateMedicalBill{
    @Autowired
    MedicalBillRepository medicalBillRepository;
    @Autowired
    FinancialEmployeeRepository financialEmployeeRepository;
    @Override
    public void payBill(String billId, String employeeId) throws NullPointerException {
        FinancialEmployee employee = financialEmployeeRepository.findById(employeeId).orElseThrow(NullPointerException::new);
        List<MedicalBill> medicalBillList = employee.getMedicalBill().stream().map(
                bill->medicalBillRepository.findById(bill.getId()).orElseThrow(NullPointerException::new)
        ).toList();
        employee.setMedicalBill(medicalBillList);
        employee.paytheBill(billId);
        financialEmployeeRepository.save(employee);
        MedicalBill medicalBill = new MedicalBill();
        medicalBill.setPaid(true);
        medicalBillRepository.save(medicalBill);
    }
}
