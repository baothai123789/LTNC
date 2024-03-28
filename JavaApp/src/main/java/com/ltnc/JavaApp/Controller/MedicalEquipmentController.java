package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.MedicalEquipment;
import com.ltnc.JavaApp.Service.MedicalEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipment")
public class MedicalEquipmentController {

    private final MedicalEquipmentService medicalEquipmentService;

    @Autowired
    public MedicalEquipmentController(MedicalEquipmentService medicalEquipmentService) {
        this.medicalEquipmentService = medicalEquipmentService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMedicalEquipment(@RequestBody MedicalEquipment equipment) {
        medicalEquipmentService.addMedicalEquipment(equipment);
        return new ResponseEntity<>("Medical equipment added successfully.", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MedicalEquipment>> getAllMedicalEquipments() {
        List<MedicalEquipment> medicalEquipments = medicalEquipmentService.getAllMedicalEquipments();
        return new ResponseEntity<>(medicalEquipments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalEquipment> getMedicalEquipmentById(@PathVariable String id) {
        Optional<MedicalEquipment> equipment = medicalEquipmentService.getMedicalEquipmentById(id);
        return equipment.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeMedicalEquipment(@PathVariable String id) {
        medicalEquipmentService.removeMedicalEquipment(id);
        return new ResponseEntity<>("Medical equipment removed successfully.", HttpStatus.OK);
    }
}
