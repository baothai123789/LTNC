package com.ltnc.JavaApp.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medicalEquipments")
public class MedicalEquipment {
    @Id
    private String id;
    private String name;
    private boolean isActive;
    private int quantity;
    private String maintenanceHistory;

    public MedicalEquipment(String id, String name, boolean isActive,int quantity, String maintenanceHistory) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.quantity = quantity;
        this.maintenanceHistory = maintenanceHistory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMaintenanceHistory() {
        return maintenanceHistory;
    }

    public void setMaintenanceHistory(String maintenanceHistory) {
        this.maintenanceHistory = maintenanceHistory;
    }
}
