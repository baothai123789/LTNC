package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddMedicalDetailService implements IAddMedicalDetailService {
    @Autowired
    private MedicalDetailRepository medicalDetailRepository;
    public void addMedicalDetail(MedicalDetail medicalDetail, MedicalDetailModel medicalDetailModel) {
        medicalDetailRepository.save(medicalDetail);
        medicalDetailModel.addMedicalDetail(medicalDetail);
    }

}