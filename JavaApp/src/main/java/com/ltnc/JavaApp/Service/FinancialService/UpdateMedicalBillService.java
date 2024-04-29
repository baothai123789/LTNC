package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Repository.MedicalBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UpdateMedicalBillService implements IUpdateMedicalBill{
    @Autowired
    MedicalBillRepository medicalBillRepository;
    @Override
    public void payBill(String billId) throws NullPointerException {
        MedicalBill medicalBill = medicalBillRepository.findById(billId).orElseThrow(()->new NullPointerException("medicalbill not found"));
        medicalBill.setPaid(true);
        medicalBill.setPayDate(LocalDate.now());
        medicalBillRepository.save(medicalBill);


    }
}
