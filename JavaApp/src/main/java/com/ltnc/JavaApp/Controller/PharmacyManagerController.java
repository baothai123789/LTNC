package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.MedicalEquipment;
import com.ltnc.JavaApp.Model.PharmacyManager;
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
    public ResponseEntity<PharmacyManager> addEquipmentToManager(
            @PathVariable String managerId,
            @RequestBody MedicalEquipment equipment
    ) {
        PharmacyManager updatedManager = addEquipmentService.addEquipment(managerId,equipment);
        return ResponseEntity.ok(updatedManager);
    }

    @PreAuthorize("hasAuthority('pharmacyemployee')")
    @DeleteMapping("/{managerId}/equipment/{equipmentId}")
    public ResponseEntity<PharmacyManager> removeEquipmentFromManager(
            @PathVariable String managerId,
            @PathVariable String equipmentId
    ) {
        PharmacyManager updatedManager = removeEquipmentService.removeEquipment(managerId, equipmentId);
        return ResponseEntity.ok(updatedManager);
    }

    @GetMapping("/equipment")
    @PreAuthorize("hasAuthority('pharmacyemployee')")
    public ResponseEntity<List<MedicalEquipment>> getAllMedicalEquipments() {
        List<MedicalEquipment> medicalEquipments = getEquipmentService.getAllMedicalEquipments();
        return ResponseEntity.ok(medicalEquipments);
    }

    @GetMapping("/equipment/{equipmentId}")
    @PreAuthorize("hasAuthority('pharmacyemployee')")
    public ResponseEntity<MedicalEquipment> getMedicalEquipmentById(@PathVariable String equipmentId) {
        MedicalEquipment medicalEquipment = getEquipmentService.getMedicalEquipmentById(equipmentId);
        if (medicalEquipment != null) {
            return ResponseEntity.ok(medicalEquipment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
