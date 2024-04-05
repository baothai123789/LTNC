package com.ltnc.JavaApp.Service.MedicalDetailService.Interface;

import java.util.List;

import com.ltnc.JavaApp.Model.MedicalDetail;


public interface IGetMedicalDetailService {
    public List<MedicalDetail> getMedicalDetails(MedicalDetailModel person);
}
