package com.ltnc.JavaApp.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.SubmissionPublisher;

@Data
@NoArgsConstructor
@Document(collection = "MedicalBill")
public class MedicalBill {
    @Id
    private String id;
    private String patient;
    private String type;
    private List<Map<String,Object>> prescription;
    private String medicalDetailId;
    private Integer medicalFee;
    private Boolean paid;
    private LocalDate hastopay;
    private Integer totalPay;
    private LocalDate payDate;
    private String financialEmployeeId;
}
