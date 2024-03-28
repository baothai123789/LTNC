package com.ltnc.JavaApp.Model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "PharmacyManagers")
public class PharmacyManager extends FunctionalEmployee{
    private List<Medicine> medicines;
    private List<MedicalEquipment> medicalEquipments;
    public PharmacyManager() {
        super();
        this.medicines = new ArrayList<>();
        this.medicalEquipments = new ArrayList<>();
        this.role = "PharmacyManager";
    }
    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public List<MedicalEquipment> getMedicalEquipments() {
        return medicalEquipments;
    }

    public void setMedicalEquipments(List<MedicalEquipment> medicalEquipments) {
        this.medicalEquipments = medicalEquipments;
    }

}
