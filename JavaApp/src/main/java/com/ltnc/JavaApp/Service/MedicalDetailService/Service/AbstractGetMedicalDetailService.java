package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.IGetMedicalDetailService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public class AbstractGetMedicalDetailService<T extends MedicalDetailModel> implements IGetMedicalDetailService {
    protected Class<T> type;
    protected MongoRepository<T,String>  modelRepository;
    protected MedicalDetailRepository medicalDetailRepository;

    @Override
    public List<MedicalDetail> getMedicalDetails(String modelId) {
        T model = modelRepository.findById(modelId).orElseThrow(NullPointerException::new);
        return model.getMedicalDetails();
    }
    @Override
    public String getType(){
        return type.getSimpleName();
    }
}
