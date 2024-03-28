package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Medicine;
import com.ltnc.JavaApp.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMedicine(@RequestBody Medicine medicine) {
        medicineService.addMedicine(medicine);
        return new ResponseEntity<>("Medicine added successfully.", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Medicine>> getAllMedicines() {
        List<Medicine> medicines = medicineService.getAllMedicines();
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable String id) {
        Optional<Medicine> medicine = medicineService.getMedicineById(id);
        return medicine.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeMedicine(@PathVariable String id) {
        medicineService.removeMedicine(id);
        return new ResponseEntity<>("Medicine removed successfully.", HttpStatus.OK);
    }
}
