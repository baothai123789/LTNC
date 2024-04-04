package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.MedicalSchedule;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.Prescription;
import com.ltnc.JavaApp.RequestModel.CreateMedicalDetailModel;
import com.ltnc.JavaApp.RequestModel.MedicalDetailInfo;
import com.ltnc.JavaApp.Service.CreateMedicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ltnc.JavaApp.Service.ICreateMedicalDetailService;
import com.ltnc.JavaApp.Service.IEditMedicalDetailService;
import com.ltnc.JavaApp.Service.IGetMedicalDetailService;
import com.ltnc.JavaApp.Service.IInfomationService;
import com.ltnc.JavaApp.Service.Factory.InformationServiceFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.ltnc.JavaApp.MyApp;
@RestController
@RequestMapping("/medicaldetail")
public class MedicalDetailController {
    @Autowired
    private ICreateMedicalDetailService createservice;
    @Autowired
    private IEditMedicalDetailService editservice;
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
