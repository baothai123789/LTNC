package com.ltnc.JavaApp.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "PharmacyManagers")
public class PharmacyManager extends FunctionalEmployee{
    @Id
    private String id;
    private int salary;
    private List<Medicine> medicines;
    private List<MedicalEquipment> medicalEquipments;
    public PharmacyManager() {
        super();
        this.medicines = new ArrayList<>();
        this.medicalEquipments = new ArrayList<>();

        this.part = "Pharmacy";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
