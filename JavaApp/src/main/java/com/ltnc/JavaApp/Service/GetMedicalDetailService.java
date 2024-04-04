package com.ltnc.JavaApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.MedicalDetailGetter;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
@Component
public class GetMedicalDetailService implements IGetMedicalDetailService {
    @Autowired
    private MedicalDetailRepository repository;

    @Override
    public List<MedicalDetail> getMedicalDetails(MedicalDetailGetter person){
        List<MedicalDetail> medicalDetails = person.getMedicalDetails();
        return medicalDetails.stream().map(medicalDetail->repository.findById(medicalDetail.getId()).get()).toList();
    }

}
