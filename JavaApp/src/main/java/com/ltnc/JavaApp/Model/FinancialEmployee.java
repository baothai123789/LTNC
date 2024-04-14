package com.ltnc.JavaApp.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "FinancialEmployee")
public class FinancialEmployee extends Employee {
    @Id
    private String id;
    private long fund;

    @DBRef
    private Map<Doctor,Integer> doctorIntegerMap = new HashMap<>();

    @DBRef
    private Map<Nurse,Integer> nurseIntegerMap = new HashMap<>();

    @DBRef
    private Map<PharmacyManager, Integer> pharmacyManagerIntegerMap = new HashMap<>();

    @DBRef
    private Map<Patient,Integer> patientIntegerMap = new HashMap<>();

    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getRole(){
        return "FinancialEmployee";
    }
}
