package com.ltnc.JavaApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document("Fee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeeOfPatient {
    @Id
    private Map<String, Integer> fees = new HashMap<>();

    public void addPatientFee(String id, int fee) {
        this.fees.put(id, fee);
    }

    public int getPatientFee(String id) {
        return this.fees.getOrDefault(id, 0);
    }
}
