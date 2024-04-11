package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.IAddMedicalDetailService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;
import lombok.Getter;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract class AbstractAddMedicalDetailService<T extends MedicalDetailModel> implements IAddMedicalDetailService {
    protected Class<T> type;
    protected MongoRepository<T,String> modelRepository;
    protected MedicalDetailRepository medicalDetailRepository;
    @Override
    public void addMedicalDetail(String doctorId,MedicalDetail newMedicalDetail) {
        T model = modelRepository.findById(doctorId).orElseThrow(NullPointerException::new);
        model.addMedicalDetail(newMedicalDetail);
        modelRepository.save(model);
        medicalDetailRepository.save(newMedicalDetail);
    }

    @Override
    public String getType() {
        return type.getSimpleName();
    }
}
