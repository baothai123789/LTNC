package com.ltnc.JavaApp.Service.MaintenanceService.Interface;

import com.ltnc.JavaApp.Model.MaintenanceHistory;
import com.ltnc.JavaApp.Service.MaintenanceService.DTO.HistoryDTO;

import java.time.LocalDate;

public interface IMaintenanceService {
    public HistoryDTO createMaintenance(LocalDate date,String detail,String equipId,Boolean active);
}
