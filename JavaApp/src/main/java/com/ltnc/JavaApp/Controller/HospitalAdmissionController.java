package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;
import com.ltnc.JavaApp.Model.PatientState;
import com.ltnc.JavaApp.Service.HospitalAdmission.Interface.IHospitalAdmissionManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hospitaladmission")
public class HospitalAdmissionController {
    @Autowired
    IHospitalAdmissionManageService hospitalAdmissionManageService;

    @GetMapping("/details/{id}")
    public ResponseEntity<List<HospitalAdmissionDetail>> getAllHospitalAdmission(@PathVariable("id") String nurseId){
        List<HospitalAdmissionDetail> hospitalAdmissionDetails;
        try{
            hospitalAdmissionDetails=hospitalAdmissionManageService.getHospitalAdmissionDetails(nurseId);
        }
        catch (NullPointerException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hospitalAdmissionDetails,HttpStatus.OK);
    }
    @PostMapping("/createdetail/{id}")
    public ResponseEntity<Map<String,String>> createNewDetail(
            @RequestBody HospitalAdmissionDetail hospitalAdmissionDetail,
            @PathVariable("id") String nurseId){
        try {
            this.hospitalAdmissionManageService.addHospitalAdmission(hospitalAdmissionDetail,nurseId);
        }
        catch (NullPointerException e){
            return new ResponseEntity<>(new HashMap<>(Map.of("message",e.getMessage())),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.CREATED);
    }
    @PutMapping("/updatepatientstate/{detailid}")
    public ResponseEntity<Map<String,String>> updatePatientState(
            @RequestBody PatientState patientState,
            @PathVariable("detailid") String detailId){
        try {
            this.hospitalAdmissionManageService.updateHopitalAdmissionState(detailId,patientState.getDetail(),patientState.getDate());
        }
        catch (NullPointerException e){
            return new ResponseEntity<>(new HashMap<>(Map.of("message","Detail not found")),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.OK);
    }
}
