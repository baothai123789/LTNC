package com.ltnc.JavaApp.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PharmacyManagers")
public class PharmacyManager extends Employee{
    @Id
    private String id;
    private List<Medicine> medicines;
    private List<MedicalEquipment> medicalEquipments;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getRole() {
        return "Pharmacy Manager";
    }


}
