package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Service.FinancialService.CreateNewMedicalBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/financial")
public class FinancialController {
    @Autowired
    CreateNewMedicalBillService createNewMedicalBillService;


    @PreAuthorize("hasAuthority('financialemployee')")
    @PostMapping("/createnewbill")
    public ResponseEntity<Map<String,String>> createNewBill(@RequestBody MedicalBill medicalBill){
        try {
            medicalBill.setId(UUID.randomUUID().toString());
            this.createNewMedicalBillService.createNewMedicalBill(medicalBill);
        }
        catch (Exception e){
            MyApp.LOGGER.info(e.getMessage());
            return new ResponseEntity<>(new HashMap<>(Map.of("message","fail")), HttpStatus.NOT_ACCEPTABLE);
        }
        return  new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.CREATED);




    }
}
