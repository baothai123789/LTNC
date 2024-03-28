package com.ltnc.JavaApp.Model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "PharmacyManagers")
public class PharmacyManager extends FunctionalEmployee{
    private final List<Medicine> medicines;
    private final List<MedicalEquipment> medicalEquipments;
    public PharmacyManager() {
        super();
        this.medicines = new ArrayList<>();
        this.medicalEquipments = new ArrayList<>();
        this.role = "PharmacyManager";
    }
    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public void removeMedicine(String id) {
        medicines.removeIf(medicine -> medicine.getId().equals(id));
    }

    public void addMedicalEquipment(MedicalEquipment equipment) {
        medicalEquipments.add(equipment);
    }

    public void removeMedicalEquipment(String id) {
        medicalEquipments.removeIf(equipment -> equipment.getId().equals(id));
    }

}
