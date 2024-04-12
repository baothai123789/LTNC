package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.RequestModel.MedicalDetail.CreateMedicalDetailModel;
import com.ltnc.JavaApp.RequestModel.MedicalDetail.MedicalDetailInfo;
import com.ltnc.JavaApp.ResponseModel.MedicalDetailResponse.DoctorMedicalDetailResponse;
import com.ltnc.JavaApp.ResponseModel.MedicalDetailResponse.NurseMedicalDetailResponse;
import com.ltnc.JavaApp.ResponseModel.MedicalDetailResponse.PatientMedicalDetailResponse;
import com.ltnc.JavaApp.Service.MedicalDetailService.Service.MedicalDetailManageService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Service.CreateMedicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/getmedicaldetails/doctor/{id}")
    private ResponseEntity<List<DoctorMedicalDetailResponse>> getDoctorMedicalDetail(@PathVariable("id") String doctorId){
        List<MedicalDetail> res;
        try {
           res=this.medicalDetailManageService.getMedicalDetail(doctorId,"doctor");
        }
        catch(NullPointerException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        List<DoctorMedicalDetailResponse> responses = res.stream().map(DoctorMedicalDetailResponse::new).toList();
        return new ResponseEntity<>(responses,HttpStatus.OK);

    }
    @GetMapping("/getmedicaldetails/patient/{id}")
     
    private ResponseEntity<List<PatientMedicalDetailResponse>> getPatientMedicalDetail(@PathVariable("id") String patientid){
        List<MedicalDetail> res;
        try {
            res = this.medicalDetailManageService.getMedicalDetail(patientid,"patient");
        }
        catch(NullPointerException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(res.stream().map(PatientMedicalDetailResponse::new).toList(),HttpStatus.OK);
    }
    @GetMapping("/getmedicaldetails/nurse/{medicalid}")
    public ResponseEntity<NurseMedicalDetailResponse> getNurseMedicalDetail(@PathVariable("medicalid") String medicalId){
        MedicalDetail res;
        try{
            res = this.medicalDetailManageService.getMedicalDetailById(medicalId);
        }
        catch (NullPointerException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new NurseMedicalDetailResponse(res),HttpStatus.OK);
    }
}
