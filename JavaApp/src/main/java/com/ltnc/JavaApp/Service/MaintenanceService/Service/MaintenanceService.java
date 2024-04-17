package com.ltnc.JavaApp.Service.MaintenanceService.Service;

import com.ltnc.JavaApp.Model.MaintenanceHistory;
import com.ltnc.JavaApp.Model.MedicalEquipment;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.MaintenanceHistoryRepository;
import com.ltnc.JavaApp.Repository.MedicalEquipmentRepository;
import com.ltnc.JavaApp.Service.MaintenanceService.DTO.HistoryDTO;
import com.ltnc.JavaApp.Service.MaintenanceService.Interface.IMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class MaintenanceService implements IMaintenanceService {
    @Autowired
    private MaintenanceHistoryRepository repository;
    @Autowired
    private MedicalEquipmentRepository equipmentRepository;

    @Override
    public HistoryDTO createMaintenance(LocalDate date,String detail,String equipId,Boolean active) {
        MaintenanceHistory history = new MaintenanceHistory();
        history.setDate(date);
        history.setDetail(detail);
        history.setEquipid(equipId);
        history.setActive(active);
        repository.save(history);

        return HistoryDTO.builder()
                .date(date)
                .equipmentId(equipId)
                .isactive(active)
                .detail(detail)
                .build();
    }
}
