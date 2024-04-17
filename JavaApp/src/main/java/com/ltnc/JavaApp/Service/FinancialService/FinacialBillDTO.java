package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.Patient;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class FinacialBillDTO {
    private String id;
    private String type;
    private List<Map<String,Object>> prescription;
    private Integer medicalFee;
    private Boolean paid;
    private LocalDate hastopay;
    private Integer totalPay;
    private PatientInfoDTO patientInfoDTO;
}
