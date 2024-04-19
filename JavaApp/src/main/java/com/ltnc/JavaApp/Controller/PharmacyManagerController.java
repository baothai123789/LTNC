package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.MedicalEquipment;
import com.ltnc.JavaApp.Model.PharmacyEquipmentManager;
import com.ltnc.JavaApp.Service.PharmacyService.Interface.IAddEquipmentService;
import com.ltnc.JavaApp.Service.PharmacyService.Interface.IGetEquipmentService;
import com.ltnc.JavaApp.Service.PharmacyService.Interface.IRemoveEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharmacymanager")
public class PharmacyManagerController {

    @Autowired
    private IAddEquipmentService addEquipmentService;

    @Autowired
    private IRemoveEquipmentService removeEquipmentService;

    @Autowired
    private IGetEquipmentService getEquipmentService;

    @PreAuthorize("hasAuthority('pharmacyemployee')")
    @PostMapping("/{managerId}/equipment")
    public ResponseEntity<PharmacyEquipmentManager> addEquipmentToManager(
            @PathVariable String managerId,
            @RequestBody MedicalEquipment equipment
    ) {
        PharmacyEquipmentManager updatedManager = addEquipmentService.addEquipment(managerId, equipment);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedManager);
    }

    @PreAuthorize("hasAuthority('pharmacyemployee')")
    @DeleteMapping("/{managerId}/equipment/{equipmentId}")
    public ResponseEntity<PharmacyEquipmentManager> removeEquipmentFromManager(
            @PathVariable String managerId,
            @PathVariable String equipmentId
    ) {
        PharmacyEquipmentManager updatedManager = removeEquipmentService.removeEquipment(managerId, equipmentId);
        return ResponseEntity.ok(updatedManager);
    }

    @GetMapping("/{managerId}/equipment")
    @PreAuthorize("hasAuthority('pharmacyemployee')")
    public ResponseEntity<List<MedicalEquipment>> getAllMedicalEquipments(
            @PathVariable String managerId) {
        List<MedicalEquipment> medicalEquipments = getEquipmentService.getAllMedicalEquipments(managerId);
        return ResponseEntity.ok(medicalEquipments);
    }

    @GetMapping("/{managerId}/equipment/{equipmentId}")
    @PreAuthorize("hasAuthority('pharmacyemployee')")
    public ResponseEntity<MedicalEquipment> getMedicalEquipmentById(
            @PathVariable String managerId,
            @PathVariable String equipmentId
    ) {
        MedicalEquipment medicalEquipment = getEquipmentService.getMedicalEquipmentById(managerId, equipmentId);
        if (medicalEquipment != null) {
            return ResponseEntity.ok(medicalEquipment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
