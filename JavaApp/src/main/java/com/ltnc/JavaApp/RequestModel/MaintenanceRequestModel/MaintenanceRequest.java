package com.ltnc.JavaApp.RequestModel.MaintenanceRequestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceRequest {
    private LocalDate maintenanceDate;
    private String equipmentId;
    private String detail;
    private Boolean active;
}
