package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.MedicalSchedule;
import com.ltnc.JavaApp.Model.Prescription;
import com.ltnc.JavaApp.RequestModel.CreateMedicalDetailModel;
import com.ltnc.JavaApp.RequestModel.MedicalDetailInfo;
import com.ltnc.JavaApp.Service.CreateMedicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.ltnc.JavaApp.MyApp;
@RestController
@RequestMapping("/medicaldetail")
public class MedicalDetailController {
    @Autowired
    private CreateMedicalDetailService createservice;


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
}
