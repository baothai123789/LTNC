package com.ltnc.JavaApp.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PharmacyManagers")
public class PharmacyManager extends FunctionalEmployee{
    @Id
    private String id;
    @DBRef
    private List<Medicine> medicines = new ArrayList<>();
    @DBRef
    private List<MedicalEquipment> medicalEquipments = new ArrayList<>();
    @DBRef
    private NotificationList notifications;
    @DBRef
    UserAccount userAccount;

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
        return "pharmacymanger";
    }
    @Override
    public String getPart() {
        return "medicalEmployee";
    }

}
