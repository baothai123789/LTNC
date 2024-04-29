package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Repository.MedicalBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddMedicalBillService implements IAddMedicalBill {
    @Autowired
    private MedicalBillRepository medicalBillRepository;




    @Override
    public void addMedicalBill(MedicalBill medicalBill,FinancialEmployee financialEmployee) throws NullPointerException{
        medicalBillRepository.save(medicalBill);
        financialEmployee.addMedicalBill(medicalBill);
    }
}
