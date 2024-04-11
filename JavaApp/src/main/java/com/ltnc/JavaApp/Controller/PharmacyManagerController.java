package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Medicine;
import com.ltnc.JavaApp.Service.PharmacyService.PharmacyManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharmacyitem")
public class PharmacyManagerController {
    private final PharmacyManagerService pharmacyManagerService;
    @Autowired
    public PharmacyManagerController(PharmacyManagerService pharmacyManagerService) {
        this.pharmacyManagerService = pharmacyManagerService;
    }
    @PostMapping("/addMedicine/{managerId}")
    public void addMedicine(@PathVariable String managerId, @RequestBody Medicine medicine) {
        pharmacyManagerService.addMedicine(managerId, medicine);
    }

    @DeleteMapping("/removeMedicine/{managerId}/{medicineId}")
    public void removeMedicine(@PathVariable String managerId, @PathVariable String medicineId) {
        pharmacyManagerService.removeMedicine(managerId, medicineId);
    }

    @GetMapping("/medicines/{managerId}")
    public List<Medicine> getAllMedicines(@PathVariable String managerId) {
        return pharmacyManagerService.getAllMedicines(managerId);
    }

}
