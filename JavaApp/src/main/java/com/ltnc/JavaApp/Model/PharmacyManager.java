package com.ltnc.JavaApp.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PharmacyManagers")
public class PharmacyManager extends FunctionalEmployee{
    @Id
    private String id;
    private int salary;
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
    public NotificationList getNotifications() {
        return null;
    }

    @Override
    public void setNotifications(NotificationList notifications) {

    }

    @Override
    public String getPart() {
        return "pharmacyManager";
    }
}
