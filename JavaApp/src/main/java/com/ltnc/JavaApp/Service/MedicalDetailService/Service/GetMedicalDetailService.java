package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import java.util.List;

import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.IGetMedicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
@Component
public class GetMedicalDetailService implements IGetMedicalDetailService {
    @Autowired
    private MedicalDetailRepository repository;

    @Override
    public List<MedicalDetail> getMedicalDetails(MedicalDetailModel person){
        List<MedicalDetail> medicalDetails = person.getMedicalDetails();
        return medicalDetails.stream().map(medicalDetail->repository.findById(medicalDetail.getId()).get()).toList();
    }

}
