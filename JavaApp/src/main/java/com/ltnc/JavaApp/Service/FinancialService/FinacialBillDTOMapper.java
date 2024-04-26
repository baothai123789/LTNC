package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.MedicalBill;
import org.springframework.stereotype.Component;

@Component
public class FinacialBillDTOMapper {
    public FinacialBillDTO map(MedicalBill medicalBill){
        return FinacialBillDTO.builder()
                .id(medicalBill.getId())
                .paid(medicalBill.getPaid())
                .type(medicalBill.getType())
                .medicalFee(medicalBill.getMedicalFee())
                .hastopay(medicalBill.getHastopay())
                .prescription(medicalBill.getPrescription())
                .totalPay(medicalBill.getTotalPay())
                .patientInfoDTO(new PatientInfoDTO(medicalBill.getPatient())).build();
    }
}
