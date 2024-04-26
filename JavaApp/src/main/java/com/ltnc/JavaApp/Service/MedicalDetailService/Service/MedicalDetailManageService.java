package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.IMedicalDetailDTO;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalDetailManageService implements IMedicalDetailManageService {
    @Autowired
    IAddMedicalDetailService addMedicalDetailService;
    @Autowired
    List<IGetMedicalDetailService> getMedicalDetailServices;
    @Autowired
    MedicalDetailRepository medicalDetailRepository;
    @Override
    public void addMedicalDetail(MedicalDetail medicalDetail, MedicalDetailModel medicalDetailModel) {
        addMedicalDetailService.addMedicalDetail(medicalDetail, medicalDetailModel);
    }
    public List<IMedicalDetailDTO> getAllMedicalDetail(String userId,String type) {
        return getMedicalDetailServices
                .stream().filter(service->service.getType().equalsIgnoreCase(type))
                .findFirst().orElseThrow(()->new NullPointerException("Service not found")).getMedicalDetail(userId);
    }
    public MedicalDetail getMedicalDetail(String medicaldetailid) {
        return medicalDetailRepository.findById(medicaldetailid).orElseThrow(()->new NullPointerException("MedicalDetail not found"));
    }
}
