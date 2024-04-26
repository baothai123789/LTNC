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


    public void addHistory(MaintenanceHistory history) {
        this.maintenanceHistory.add(history);
    }

    public boolean updateHistory(String historyId, MaintenanceHistory updatedHistory) {
        for (int i = 0; i < maintenanceHistory.size(); i++) {
            MaintenanceHistory history = maintenanceHistory.get(i);
            if (history.getId().equals(historyId)) {
                history.setDate(updatedHistory.getDate());
                history.setDetail(updatedHistory.getDetail());
                history.setActive(updatedHistory.getActive());
                maintenanceHistory.set(i, history);
                return true;
            }
        }
        return false;
    }
}
