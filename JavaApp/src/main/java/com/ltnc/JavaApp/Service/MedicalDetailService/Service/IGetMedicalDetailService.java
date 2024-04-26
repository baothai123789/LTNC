package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.IMedicalDetailDTO;

import java.util.List;

public interface IGetMedicalDetailService {
    public List<IMedicalDetailDTO> getMedicalDetail(String userId);
    public String getType();

}
