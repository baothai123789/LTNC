package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Service.FinancialService.Interface.IAddToListOfEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/financial/employee")
public class FinancialForEmployeeController {

    @Autowired
    private IAddToListOfEmployeeService addToListOfEmployeeService;

    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;


    @PostMapping("/{financialEmployeeId}/doctor")
    public ResponseEntity<String> addDoctorToFinancialEmployee(@PathVariable String financialEmployeeId, @RequestBody Doctor doctor) {
        FinancialEmployee financialEmployee = financialEmployeeRepository.findById(financialEmployeeId)
                .orElseThrow(() -> new RuntimeException("Financial Employee not found with id: " + financialEmployeeId));

        addToListOfEmployeeService.addDoctorToMap(financialEmployee, doctor);
        return ResponseEntity.ok("Doctor added to Financial Employee successfully.");
    }


    @PostMapping("/{financialEmployeeId}/nurse")
    public ResponseEntity<String> addNurseToFinancialEmployee(@PathVariable String financialEmployeeId, @RequestBody Nurse nurse) {
        FinancialEmployee financialEmployee = financialEmployeeRepository.findById(financialEmployeeId)
                .orElseThrow(() -> new RuntimeException("Financial Employee not found with id: " + financialEmployeeId));

        addToListOfEmployeeService.addNurseToMap(financialEmployee, nurse);
        return ResponseEntity.ok("Nurse added to Financial Employee successfully.");
    }

    @PostMapping("/{financialEmployeeId}/pharmacyManager")
    public ResponseEntity<String> addPharmacyManagerToFinancialEmployee(@PathVariable String financialEmployeeId, @RequestBody PharmacyManager pharmacyManager) {
        FinancialEmployee financialEmployee = financialEmployeeRepository.findById(financialEmployeeId)
                .orElseThrow(() -> new RuntimeException("Financial Employee not found with id: " + financialEmployeeId));

        addToListOfEmployeeService.addPharmacyManagerToMap(financialEmployee, pharmacyManager);
        return ResponseEntity.ok("Pharmacy Manager added to Financial Employee successfully.");
    }
}
