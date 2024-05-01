package com.ltnc.JavaApp.Service.FinancialService;


import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Repository.MedicalBillRepository;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class UpdateMedicalBillService implements IUpdateMedicalBill{
    @Resource
    MedicalBillRepository medicalBillRepository;
    @Override
    public void payBill(String billId) throws NullPointerException {
        MedicalBill medicalBill = medicalBillRepository.findById(billId).orElseThrow(()->new NullPointerException("medicalbill not found"));
        medicalBill.setPaid(true);
        medicalBill.setPayDate(LocalDate.now());
        medicalBillRepository.save(medicalBill);


    }
}
