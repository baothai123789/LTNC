package com.ltnc.JavaApp.Service.MedicalDetailService.Interface;

import com.ltnc.JavaApp.Model.MedicalDetail;

import java.util.List;

public interface MedicalDetailModel {
    public List<MedicalDetail> getMedicalDetails();
    public void addMedicalDetail(MedicalDetail medicalDetail);
}
