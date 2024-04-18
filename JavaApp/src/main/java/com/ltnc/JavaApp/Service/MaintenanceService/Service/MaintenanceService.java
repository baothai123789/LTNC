package com.ltnc.JavaApp.Service.MaintenanceService.Service;

import com.ltnc.JavaApp.Model.MaintenanceHistory;
import com.ltnc.JavaApp.Model.MedicalEquipment;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.MaintenanceHistoryRepository;
import com.ltnc.JavaApp.Repository.MedicalEquipmentRepository;
import com.ltnc.JavaApp.Service.MaintenanceService.DTO.HistoryDTO;
import com.ltnc.JavaApp.Service.MaintenanceService.Interface.IMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class MaintenanceService implements IMaintenanceService {

    @Autowired
    private MaintenanceHistoryRepository historyRepository;

    @Autowired
    private MedicalEquipmentRepository equipmentRepository;

    @Override
    @Transactional
    public HistoryDTO createMaintenance(LocalDate date, String detail, String equipId, Boolean active) {
        MedicalEquipment equipment = equipmentRepository.findById(equipId)
                .orElseThrow(() -> new IllegalArgumentException("Equipment not found with id: " + equipId));

        MaintenanceHistory history = new MaintenanceHistory();
        history.setDate(date);
        history.setDetail(detail);
        history.setEquipid(equipId);
        history.setActive(active);

        historyRepository.save(history);

        equipment.addHistory(history);
        equipmentRepository.save(equipment);


        return HistoryDTO.builder()
                .date(date)
                .equipmentId(equipId)
                .isactive(active)
                .detail(detail)
                .build();
    }

    @Override
    @Transactional
    public HistoryDTO updateMaintenance(String id, LocalDate date, String equipmentId, String detail, Boolean active) {
        MaintenanceHistory existingHistory = historyRepository.findById(id).orElse(null);
        MedicalEquipment equipment = equipmentRepository.findById(equipmentId).orElse(null);
        if (existingHistory != null && equipment != null) {
            existingHistory.setDate(date);
            existingHistory.setDetail(detail);
            existingHistory.setEquipid(equipmentId);
            existingHistory.setActive(active);

            equipment.updateHistory(id,existingHistory);
            equipmentRepository.save(equipment);

            historyRepository.save(existingHistory);

            return HistoryDTO.builder()
                    .date(existingHistory.getDate())
                    .equipmentId(existingHistory.getEquipid())
                    .isactive(existingHistory.getActive())
                    .detail(existingHistory.getDetail())
                    .build();
        } else {
            throw new IllegalArgumentException("Maintenance history or equipment not found with id");
        }
    }
}
