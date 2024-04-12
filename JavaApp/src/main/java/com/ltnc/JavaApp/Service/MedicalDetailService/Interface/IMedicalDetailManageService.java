package com.ltnc.JavaApp.Service.MedicalDetailService.Interface;

import com.ltnc.JavaApp.Model.MedicalDetail;

import java.util.List;

public interface IMedicalDetailManageService {
    public void addMedicalDetail(MedicalDetail medicalDetail,String doctorId,String type);
    public void updateMedicalDetail(MedicalDetail medicalDetail,String doctorId);
    public List<MedicalDetail> getMedicalDetail(String modelId, String type);
    public  MedicalDetail getMedicalDetailById(String medicalDetailId);
}
