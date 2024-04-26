package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Repository.MedicalBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMedicalBill implements IGetMedicalBill {
    @Autowired
    private MedicalBillRepository medicalBillRepository;
    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;

    @Override
    public List<MedicalBill> getMedicalBills(String userid, Boolean paid) {
        FinancialEmployee financialEmployee = financialEmployeeRepository.findById(userid).orElseThrow(NullPointerException::new);
        return financialEmployee.getMedicalBill().stream().map(
                medicalBill -> medicalBillRepository
                        .findMedicalBillByPaid(medicalBill.getId(),paid).stream().findFirst().orElseThrow(NullPointerException::new))
                .toList();
    }
}
