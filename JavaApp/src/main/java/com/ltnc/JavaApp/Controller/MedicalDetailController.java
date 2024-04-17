package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.MedicalDetail;

import com.ltnc.JavaApp.RequestModel.MedicalDetail.CreateMedicalDetailModel;
import com.ltnc.JavaApp.RequestModel.MedicalDetail.MedicalDetailInfo;
import com.ltnc.JavaApp.Service.MedicalDetailService.Service.CreateMedicalDetailService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Service.MedicalDetailManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medicaldetail")
public class MedicalDetailController {
    @Autowired
    CreateMedicalDetailService createMedicalDetailService;
    @Autowired
    MedicalDetailManageService medicalDetailManageService;


    @PreAuthorize("hasAuthority('doctor')")
    @PostMapping("/createmedicaldetail")
    public ResponseEntity<Map<String,String>> createMedicalDetail(@RequestBody CreateMedicalDetailModel createMedicalDetailModel){
        MedicalDetail medicalDetail = createMedicalDetailModel.getDetail();
        MedicalDetailInfo info = createMedicalDetailModel.getInfo();
        this.createMedicalDetailService.createMedicalDetail(
                medicalDetail,info.getDoctorId(), info.getPatientId()
        );
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")), HttpStatus.CREATED);
    }
    @PreAuthorize("hasAuthority('doctor')")
    @GetMapping("/getmedicaldetail/doctor/{id}")
    public ResponseEntity<List<MedicalDetail>> getMedicalDetailDoctor(@PathVariable("id") String id){
        List<MedicalDetail> res = this.medicalDetailManageService.getMedicalDetail(id,"doctor");
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('patient')")
    @GetMapping("/getmedicaldetail/patient/{id}")
    public ResponseEntity<List<MedicalDetail>> getMedicalDetailPatient(@PathVariable("id") String id){
        List<MedicalDetail> res = this.medicalDetailManageService.getMedicalDetail(id,"patient");
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('nurse')")
    @GetMapping("/getmedicaldetail/nurse/{medicalid}")
    public ResponseEntity<MedicalDetail> getMedicalDetailNurse(@PathVariable("medicalid") String medicalid){
        MedicalDetail res = this.medicalDetailManageService.getMedicalDetailById(medicalid);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('doctor')")
    @PutMapping("/updatemedicaldetail/{medicaldetailid}")
    public ResponseEntity<Map<String,String>> updateMedicalDetail(
            @RequestBody MedicalDetail newmedicaldetail,
            @PathVariable("medicaldetailid")String medicaldetailid){
        this.medicalDetailManageService.updateMedicalDetail(newmedicaldetail,medicaldetailid);
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.OK);
    }
}


