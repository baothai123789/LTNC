package com.ltnc.JavaApp.Service;

import java.util.List;

import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.MedicalDetailGetter;


public interface IGetMedicalDetailService {
    public List<MedicalDetail> getMedicalDetails(MedicalDetailGetter person);
}
