package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.RequestModel.MedicalDetail.CreateMedicalDetailModel;
import com.ltnc.JavaApp.RequestModel.MedicalDetail.MedicalDetailInfo;
import com.ltnc.JavaApp.Service.InformationService.Interface.IInfomationService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.IUpdateMedicalDetailService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.IGetMedicalDetailService;
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
    private ICreateMedicalDetailService createservice;
    @Autowired
    private IUpdateMedicalDetailService editservice;
    @Autowired
    private InformationServiceFactory informationServiceFactory;


    @Autowired
    IGetMedicalDetailService getMedicalDetailService;

    @PostMapping("/create")
    private ResponseEntity<Map<String,String>> createMedicalDetail(
            @RequestBody CreateMedicalDetailModel createMedicalDetailModel
            )
    {
        MedicalDetail detail = createMedicalDetailModel.getDetail();
        MedicalDetailInfo info = createMedicalDetailModel.getInfo();
        String message=createservice.createMedicalDetail(detail,info.getPatientId(),info.getDoctorId());
        return new ResponseEntity<>(new HashMap<>(Map.of("message",message)),message.equalsIgnoreCase("success")?
                HttpStatus.OK:HttpStatus.NOT_ACCEPTABLE);
    }
    @PutMapping("/edit/{id}")
    private ResponseEntity<Map<String,String>> editMedicalDetail(
        @PathVariable("id") String id,
        @RequestBody MedicalDetail newdetail 
    ){
        String message = editservice.editMedicalDetail(id, newdetail); 
        return new ResponseEntity<>(new HashMap<>(Map.of("message",message)),message.equalsIgnoreCase("success")?
                HttpStatus.OK:HttpStatus.NOT_ACCEPTABLE);
    }
    @GetMapping("/doctor/medicaldetails/{id}")
    private ResponseEntity<List<MedicalDetail>> getDoctorMedicalDetail(@PathVariable("id") String doctorid){
        IInfomationService infomationService = informationServiceFactory.getInfomationService("doctor").get();
        Doctor doctor = (Doctor)infomationService.getData(doctorid).orElse(null);
        if(doctor==null) return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
        List<MedicalDetail> medicalDetails = getMedicalDetailService.getMedicalDetails(doctor);
        return new ResponseEntity<>(medicalDetails,HttpStatus.OK);

    }
    @GetMapping("/patient/medicaldetails/{id}")
     
    private ResponseEntity<List<MedicalDetail>> getPatientMedicalDetail(@PathVariable("id") String patientid){
        IInfomationService infomationService = informationServiceFactory.getInfomationService("patient").get();
        Patient patient = (Patient)infomationService.getData(patientid).orElse(null);
        if(patient==null) return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
        List<MedicalDetail> medicalDetails = getMedicalDetailService.getMedicalDetails(patient);
        return new ResponseEntity<>(medicalDetails,HttpStatus.OK);

    }
}
