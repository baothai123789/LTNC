package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import java.util.Optional;

import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.IUpdateMedicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;


@Component
public class UpdateMedicalDetailService implements IUpdateMedicalDetailService {
    @Autowired
    MedicalDetailRepository repository;

    @Override
    public void updateMedicalDetail(String id,MedicalDetail newDetail){
        newDetail.setId(id);
        repository.save(newDetail);
    }
}
