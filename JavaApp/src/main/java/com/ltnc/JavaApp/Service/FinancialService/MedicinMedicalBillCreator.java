package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MedicinMedicalBillCreator implements IMedicalBillCreator{
    @Override
    public MedicalBill createBill(Map<String,Object> data,Patient patient) {
        MedicalBill medicalBill = new MedicalBill();
        medicalBill.setId(UUID.randomUUID().toString());
        medicalBill.setPatient(patient);
        medicalBill.setType("Hoá đơn thuốc");
        medicalBill.setMedicalFee(0);
        medicalBill.setPrescription((List<Map<String, Object>>) data.get("medicine"));
        return medicalBill;
    }

    @Override
    public String getType() {
        return "medicinebill";
    }
}
