package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.MedicalEquipment;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Service.PharmacyService.AddEquipmentService;
import com.ltnc.JavaApp.Service.PharmacyService.RemoveEquipmentService;
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
    private AddEquipmentService addEquipmentService;

    @Autowired
    private RemoveEquipmentService removeEquipmentService;

    @PreAuthorize("hasAuthority('pharmacyemployee')")
    @PostMapping("/{managerId}/equipment")
    public ResponseEntity<PharmacyManager> addEquipmentToManager(
            @PathVariable String managerId,
            @RequestBody MedicalEquipment equipment
    ) {
        PharmacyManager updatedManager = addEquipmentService.addEquipment(equipment);
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


}
