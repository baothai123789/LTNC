package com.ltnc.JavaApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "MedicalEquipments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalEquipment {
    @Id
    private String id;
    private String name;
    private List<MaintenanceHistory> maintenanceHistory;


}
