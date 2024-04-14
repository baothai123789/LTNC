package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Service.FinancialService.Interface.IAddToListOfPatientService;
import com.ltnc.JavaApp.Service.FinancialService.Interface.ISetToListOfPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/financial/patient")
public class FinancialForPatientController {

    @Autowired
    private IAddToListOfPatientService addToListOfPatientService;

    @Autowired
    private ISetToListOfPatientService setToListOfPatientService;

    @PostMapping("/add")
    public void addPatientToMap(@RequestBody FinancialEmployee financialEmployee, @RequestBody Patient patient) {
        addToListOfPatientService.addPatientToMap(financialEmployee, patient);
    }

    @PostMapping("/setFee")
    public void setPatientMap(@RequestBody Patient patient, @RequestParam int fee) {
        setToListOfPatientService.setPatientMap(patient, fee);
    }
}
