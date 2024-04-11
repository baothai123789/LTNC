package com.ltnc.JavaApp.Service.MedicalDetailService.Interface;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalDetail;

public interface IUpdateMedicalDetailService {
    public void updateMedicalDetail(String medicalDetailId,MedicalDetail newDetail);
}
