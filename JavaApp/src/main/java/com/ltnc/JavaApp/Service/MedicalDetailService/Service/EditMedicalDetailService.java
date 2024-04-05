package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import java.util.Optional;

import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.IEditMedicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;


@Component
public class EditMedicalDetailService implements IEditMedicalDetailService {
    @Autowired
    MedicalDetailRepository repository;

    @Override
    public String editMedicalDetail(String id,MedicalDetail newdetail){
        Optional<MedicalDetail> medicalDetail = repository.findById(id);
        if(medicalDetail.isEmpty()) return "Medical Detail not found";
        newdetail.setId(medicalDetail.get().getId());
        try{
            repository.save(newdetail);
        }
        catch(Exception e){
            MyApp.LOGGER.info(e.getMessage());
            return "can not save new medical detail";   
        }
        return "success";
    }
}
