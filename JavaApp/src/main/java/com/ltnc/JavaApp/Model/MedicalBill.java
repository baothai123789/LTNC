package com.ltnc.JavaApp.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@Document(collection = "MedicalBill")
public class MedicalBill {
    @Id
    private String id;
    @DBRef
    private MedicalDetail medicalDetail;
    private List<Map<String,Object>> prescription;
    private Integer medicalFee;
    private Boolean paid;
    private LocalDate hastopay;
    private Integer totalPay;

}
