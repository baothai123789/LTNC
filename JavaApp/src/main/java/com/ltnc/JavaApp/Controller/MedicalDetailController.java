package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.MedicalDetail;

import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.RequestModel.MedicalDetail.CreateMedicalDetailModel;
import com.ltnc.JavaApp.RequestModel.MedicalDetail.MedicalDetailInfo;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.IMedicalDetailDTO;
import com.ltnc.JavaApp.Service.MedicalDetailService.Service.CreateMedicalDetail;
import com.ltnc.JavaApp.Service.MedicalDetailService.Service.IGetMedicalDetailService;
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
@CrossOrigin(origins = "*")
@RequestMapping("/medicaldetail")
public class MedicalDetailController {
    @Autowired
    CreateMedicalDetail createMedicalDetail;
    @Autowired
    MedicalDetailManageService medicalDetailManageService;

    @PreAuthorize("hasAuthority('doctor')")
    @PostMapping("/createmedicaldetail")
    public ResponseEntity<Map<String, String>> createMedicalDetail(@RequestBody CreateMedicalDetailModel createMedicalDetailModel) {
        MyApp.LOGGER.info(createMedicalDetailModel);
        MedicalDetail medicalDetail = createMedicalDetailModel.getDetail();
        MedicalDetailInfo info = createMedicalDetailModel.getInfo();
        this.createMedicalDetail.createMedicalDetail(
                info.getDoctorId(), info.getPatientId(),
                medicalDetail
        );
        return new ResponseEntity<>(new HashMap<>(Map.of("message", "success")), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('doctor')")
    @GetMapping("/getmedicaldetail/doctor/{id}")
    public ResponseEntity<List<IMedicalDetailDTO>> getMedicalDetailDoctor(@PathVariable("id") String id) {
        try {

            List<IMedicalDetailDTO> res = medicalDetailManageService.getAllMedicalDetail(id, "doctor");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('patient')")
    @GetMapping("/getmedicaldetail/patient/{id}")
    public ResponseEntity<List<IMedicalDetailDTO>> getMedicalDetailPatient(@PathVariable("id") String id) {
        List<IMedicalDetailDTO> res = medicalDetailManageService.getAllMedicalDetail(id, "patient");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}


