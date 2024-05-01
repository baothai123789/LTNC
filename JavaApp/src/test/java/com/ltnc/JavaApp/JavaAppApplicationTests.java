package com.ltnc.JavaApp;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Repository.MedicalBillRepository;
import com.ltnc.JavaApp.Service.FinancialService.FinacialBillDTO;
import com.ltnc.JavaApp.Service.FinancialService.MedicalBillManage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class JavaAppApplicationTests{
    @Autowired
    MedicalBillManage medicalBillManage;
    @Test
    public void testMedicalBillRepository(){
    }
}