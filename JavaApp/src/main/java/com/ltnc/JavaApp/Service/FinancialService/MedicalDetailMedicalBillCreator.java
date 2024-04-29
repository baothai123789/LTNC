package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import com.mongodb.lang.Nullable;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MedicalDetailMedicalBillCreator implements IMedicalBillCreator{

    @Override
    public MedicalBill createBill(MedicalDetail medicalDetail,List<Map<String, Object>> presciption, @Nonnull Patient patient) {
        MedicalBill medicalBill=new MedicalBill();
        medicalBill.setId(UUID.randomUUID().toString());
        medicalBill.setPatient(patient);
        medicalBill.setType("Hoá đơn khám bệnh");
        medicalBill.setPatient(patient);
        medicalBill.setMedicalFee(300000);
        medicalBill.setPaid(false);
        medicalBill.setPayDate(null);
        medicalBill.setHastopay(LocalDate.now().plusDays(7));
        return medicalBill;
    }

    @Override
    public String getType() {
        return "medicaldetailbill";
    }
}
