package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.MedicalDetail;

import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.RequestModel.MedicalDetail.CreateMedicalDetailModel;
import com.ltnc.JavaApp.RequestModel.MedicalDetail.MedicalDetailInfo;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.IMedicalDetailDTO;
import com.ltnc.JavaApp.Service.MedicalDetailService.Service.CreateMedicalDetail;
import com.ltnc.JavaApp.Service.MedicalDetailService.Service.GetMedicalDetailFactory;
import com.ltnc.JavaApp.Service.MedicalDetailService.Service.IGetMedicalDetailService;
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
    CreateMedicalDetail createMedicalDetail;
    @Autowired
    GetMedicalDetailFactory getMedicalDetailFactory;


    @PreAuthorize("hasAuthority('doctor')")
    @PostMapping("/createmedicaldetail")
    public ResponseEntity<Map<String,String>> createMedicalDetail(@RequestBody CreateMedicalDetailModel createMedicalDetailModel){
        MyApp.LOGGER.info(createMedicalDetailModel);
        MedicalDetail medicalDetail = createMedicalDetailModel.getDetail();
        MedicalDetailInfo info = createMedicalDetailModel.getInfo();
        this.createMedicalDetail.createMedicalDetail(
                info.getDoctorId(), info.getPatientId(),
                medicalDetail
        );
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")), HttpStatus.CREATED);
    }
    @PreAuthorize("hasAuthority('doctor')")
    @GetMapping("/getmedicaldetail/doctor/{id}")
    public ResponseEntity<List<IMedicalDetailDTO>> getMedicalDetailDoctor(@PathVariable("id") String id){
        try {
            IGetMedicalDetailService getMedicalDetailService = getMedicalDetailFactory.getMedicalDetailService("doctor");
            List<IMedicalDetailDTO> res = getMedicalDetailService.getMedicalDetail(id);
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
        catch (NullPointerException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @PreAuthorize("hasAuthority('patient')")
    @GetMapping("/getmedicaldetail/patient/{id}")
    public ResponseEntity<List<IMedicalDetailDTO>> getMedicalDetailPatient(@PathVariable("id") String id){
        IGetMedicalDetailService getMedicalDetailService = getMedicalDetailFactory.getMedicalDetailService("patient");
        List<IMedicalDetailDTO> res = getMedicalDetailService.getMedicalDetail(id);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('nurse')")
    @GetMapping("/getmedicaldetail/nurse/{medicalid}")
    public ResponseEntity<MedicalDetail> getMedicalDetailNurse(@PathVariable("medicalid") String medicalid){
        IGetMedicalDetailService getMedicalDetailService = getMedicalDetailFactory.getMedicalDetailService("doctor");
        return  null;
    }
//    @PreAuthorize("hasAuthority('doctor')")
//    @PutMapping("/updatemedicaldetail/{medicaldetailid}")
//    public ResponseEntity<Map<String,String>> updateMedicalDetail(
//            @RequestBody MedicalDetail newmedicaldetail,
//            @PathVariable("medicaldetailid")String medicaldetailid){
//        this.medicalDetailManageService.updateMedicalDetail(newmedicaldetail,medicaldetailid);
//        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.OK);
//    }
}


