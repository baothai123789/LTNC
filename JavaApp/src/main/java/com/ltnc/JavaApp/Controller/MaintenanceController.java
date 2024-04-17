package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.MaintenanceHistory;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.RequestModel.MaintenanceRequestModel.MaintenanceRequest;
import com.ltnc.JavaApp.Service.MaintenanceService.DTO.HistoryDTO;
import com.ltnc.JavaApp.Service.MaintenanceService.Service.MaintenanceService;
import com.ltnc.JavaApp.Service.MaintenanceService.Service.StatByMonthService;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.PatientScheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenancehistory")
public class MaintenanceController {
    @Autowired
    private MaintenanceService maintenanceService;

    @Autowired
    private StatByMonthService statByMonthService;

    @PreAuthorize("hasAuthority('pharmacyemployee')")
    @PostMapping("/createmaintenance")
    public ResponseEntity<HistoryDTO> createMaintenance(@RequestBody MaintenanceRequest maintenanceRequest) {
        MyApp.LOGGER.info(maintenanceRequest);
        HistoryDTO historyDTO = maintenanceService.createMaintenance(
                maintenanceRequest.getMaintenanceDate(),
                maintenanceRequest.getEquipmentId(),
                maintenanceRequest.getDetail(),
                maintenanceRequest.getActive()
        );
        MyApp.LOGGER.info(historyDTO);
        return new ResponseEntity<>(historyDTO,historyDTO==null? HttpStatus.NOT_FOUND:HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('pharmacyemployee')")
    @GetMapping("/maintenance/inMonth")
    public List<MaintenanceHistory> getMaintenanceInMonth(
            @RequestParam("year") int year,
            @RequestParam("month") int month){
        return statByMonthService.findMaintenanceInMonth(year, month);
    }
}
