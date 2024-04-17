package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Model.PatientState;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.HospitalAdmissionDetailDTO;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.NurseDTOMapper;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.NurseInfoDTO;
import com.ltnc.JavaApp.Service.HospitalAdmission.Interface.IHospitalAdmissionManageService;
import com.ltnc.JavaApp.Service.HospitalAdmission.Service.CreateHospitalAdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hospitaladmission")
public class HospitalAdmissionController {
    @Autowired
    IHospitalAdmissionManageService hospitalAdmissionManageService;
    @Autowired
    CreateHospitalAdmissionService createHospitalAdmissionService;

    @PreAuthorize("hasAuthority('nurse')")
    @GetMapping("/details/{id}")
    public ResponseEntity<List<HospitalAdmissionDetailDTO>> getAllHospitalAdmission(@PathVariable("id") String nurseId){
        List<HospitalAdmissionDetailDTO> hospitalAdmissionDetails;
        try{
            hospitalAdmissionDetails=hospitalAdmissionManageService.getHospitalAdmissionDetails(nurseId);
        }
        catch (NullPointerException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hospitalAdmissionDetails,HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('doctor')")
    @PostMapping("/createdetail/")
    public ResponseEntity<NurseInfoDTO> createNewDetail(
            @RequestBody HospitalAdmissionDetail hospitalAdmissionDetail){
        NurseInfoDTO nurse = createHospitalAdmissionService.createHospitalAdmission(hospitalAdmissionDetail);
        if(nurse==null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(nurse,HttpStatus.CREATED);
    }
    @PreAuthorize("hasAnyAuthority('nurse','doctor')")
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
