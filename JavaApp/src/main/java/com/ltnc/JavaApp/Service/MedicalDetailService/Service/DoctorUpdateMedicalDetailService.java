package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.IUpdateMedicalDetailService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorUpdateMedicalDetailService implements IUpdateMedicalDetailService {
    @Autowired
    MedicalDetailRepository medicalDetailRepository;
    @Override
    public void updateMedicalDetail(String medicalDetailId, MedicalDetail newDetail) {
        newDetail.setId(medicalDetailId);
        medicalDetailRepository.save(newDetail);
    }
}
