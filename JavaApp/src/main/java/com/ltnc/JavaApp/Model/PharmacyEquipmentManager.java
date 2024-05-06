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

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PharmacyManagers")
public class PharmacyEquipmentManager extends FunctionalEmployee{
    @Id
    private String id;
    @DBRef
    private List<MedicalEquipment> medicalEquipments = new ArrayList<>();

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
        return "pharmacymanger";
    }

    @Override
    public String getMajor() {
        return "Quản Trị Thiết Bị";
    }

    @Override
    public void setMajor(String major) {
    }
}
