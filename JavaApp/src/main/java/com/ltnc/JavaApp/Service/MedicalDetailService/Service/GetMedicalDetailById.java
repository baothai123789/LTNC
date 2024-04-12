package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.IGetMedicalDetailById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetMedicalDetailById implements IGetMedicalDetailById {
    @Autowired
    MedicalDetailRepository medicalDetailRepository;
    @Override
    public MedicalDetail getMedicalDetail(String medicalDetailId) throws NullPointerException{
        return medicalDetailRepository.findById(medicalDetailId).orElseThrow(NullPointerException::new);
    }
}
