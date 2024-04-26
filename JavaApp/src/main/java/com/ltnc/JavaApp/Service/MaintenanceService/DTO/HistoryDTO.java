package com.ltnc.JavaApp.Service.MaintenanceService.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
public class HistoryDTO {
    private LocalDate date;
    private String detail;
    private String equipmentId;
    private Boolean isactive;
}
