package com.ltnc.JavaApp.Service.PharmacyManager;

import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Service.FinancialService.MedicalBillManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CreateNewMedicineBill {
    @Autowired
    IMedicineManageService medicineManageService;
    @Autowired
    MedicalBillManage medicalBillManage;
    public void createNewMedicalBill(List<Map<String,Object>> presciption){
        MedicalBill medicalBill = new MedicalBill();
        medicalBill.setType("Hoá đơn thuốc");
        medicalBill.setMedicalFee(0);
        medicalBill.setPrescription(presciption);
        medicalBillManage.addMedicalBill(medicalBill);
        medicineManageService.removeMedicineFromPresciption(presciption);
    }
}
