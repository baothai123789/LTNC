package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Medicine;
import com.ltnc.JavaApp.RequestModel.MedicinRequestModel.MedicinCreateRequestModel;
import com.ltnc.JavaApp.ResponseModel.Pharmacy.MedicinePriceResponse;
import com.ltnc.JavaApp.Service.FinancialService.CreateNewMedicalBillService;
import com.ltnc.JavaApp.Service.PharmacyManager.CreatePresciptionService;
import com.ltnc.JavaApp.Service.PharmacyManager.MedicineManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pharmacy")
public class PharmacyController {
    @Autowired
    MedicineManageService medicineManageService;
    @Autowired
    CreatePresciptionService createPresciptionService;

    @PreAuthorize("hasAuthority('pharmacymanager')")
    @PostMapping("/addmedicine")
    public ResponseEntity<Map<String,String>> addMedicine(@RequestBody List<Medicine> medicineList){
        medicineManageService.addMedicines(medicineList);
        return new ResponseEntity<>(new HashMap<>(Map.of("message","succcess")), HttpStatus.CREATED);
    }
    @PreAuthorize("hasAuthority('pharmacymanager')")
    @GetMapping("/getmedicine")
    public ResponseEntity<List<Medicine>> getMedicines(){
        List<Medicine> medicines=medicineManageService.getMedicines();
        return new ResponseEntity<>(medicines,HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('pharmacymanager')")
    @GetMapping("/getpresciption")
    public ResponseEntity<MedicinePriceResponse> getMedicinePrice(@RequestBody List<Map<String,Object>> presciption){
        Integer total= this.medicineManageService.getMedicinesPrice(presciption);
        MedicinePriceResponse medicinePriceResponse= new MedicinePriceResponse(presciption,total);
        return new ResponseEntity<>(medicinePriceResponse,HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('pharmacymanager')")
    @PostMapping("/createpresciption")
    public ResponseEntity<Map<String,String>> createPresciption(@RequestBody MedicinCreateRequestModel medicinCreateRequestModel){
        createPresciptionService.createNewPresciption(medicinCreateRequestModel);
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.CREATED);
    }


}
