package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.IMedicalDetailDTO;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;

import java.util.List;

public interface IGetMedicalDetailService {
    public List<IMedicalDetailDTO> getMedicalDetail(String userid);
    public String getType();
}
