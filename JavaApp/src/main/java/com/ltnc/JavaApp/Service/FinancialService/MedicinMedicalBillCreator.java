package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import jakarta.annotation.Nonnull;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MedicinMedicalBillCreator implements IMedicalBillCreator{
    @Override
    public MedicalBill createBill(MedicalDetail medicalDetail, List<Map<String, Object>> presciption, @Nonnull Patient patient) {
        if(presciption==null) throw new NullPointerException("wrong class");
        MedicalBill medicalBill = new MedicalBill();
        medicalBill.setId(UUID.randomUUID().toString());
        medicalBill.setPatient(patient);
        medicalBill.setType("Hoá đơn thuốc");
        medicalBill.setMedicalFee(0);
        medicalBill.setPrescription(presciption);
        return medicalBill;
    }

    @Override
    public String getType() {
        return "medicinebill";
    }
}
