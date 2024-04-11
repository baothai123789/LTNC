package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.RequestModel.MedicalDetail.CreateMedicalDetailModel;
import com.ltnc.JavaApp.RequestModel.MedicalDetail.MedicalDetailInfo;
import com.ltnc.JavaApp.Service.InformationService.Interface.IInfomationService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.IUpdateMedicalDetailService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.IGetMedicalDetailService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Service.MedicalDetailManageService;
import com.ltnc.JavaApp.Service.ScheduleService.Service.CreateMedicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ltnc.JavaApp.Service.InformationService.Factory.InformationServiceFactory;

import java.util.ArrayList;
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

    @PostMapping("/create")
    private ResponseEntity<Map<String,String>> createMedicalDetail(
            @RequestBody CreateMedicalDetailModel createMedicalDetailModel
            )
    {
        MedicalDetail detail = createMedicalDetailModel.getDetail();
        MedicalDetailInfo info = createMedicalDetailModel.getInfo();
        try{
            this.createMedicalDetailService.createMedicalDetail(detail,info.getDoctorId(),info.getPatientId());
        }
        catch(NullPointerException e){
            return new ResponseEntity<>(new HashMap<>(Map.of("message",e.getMessage())),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new HashMap<>(Map.of("message","Medical detail created!")),HttpStatus.CREATED);
    }
    @PutMapping("/edit/{id}")
    private ResponseEntity<Map<String,String>> editMedicalDetail(
        @PathVariable("id") String id,
        @RequestBody MedicalDetail newDetail
    ){
        try{
            this.medicalDetailManageService.updateMedicalDetail(newDetail,id);
        }
        catch(NullPointerException e){
            return new ResponseEntity<>(new HashMap<>(Map.of("message",e.getMessage())),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new HashMap<>(Map.of("message","Medical detail updated!")),HttpStatus.OK);
    }
    @GetMapping("/doctor/medicaldetails/{id}")
    private ResponseEntity<List<MedicalDetail>> getDoctorMedicalDetail(@PathVariable("id") String doctorId){
        List<MedicalDetail> res;
        try {
           res=this.medicalDetailManageService.getMedicalDetail(doctorId,"doctor");
        }
        catch(NullPointerException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(res,HttpStatus.OK);

    }
    @GetMapping("/patient/medicaldetails/{id}")
     
    private ResponseEntity<List<MedicalDetail>> getPatientMedicalDetail(@PathVariable("id") String patientid){
        List<MedicalDetail> res;
        try {
            res = this.medicalDetailManageService.getMedicalDetail(patientid,"patient");
        }
        catch(NullPointerException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(res,HttpStatus.OK);

    }
}
