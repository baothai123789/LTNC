package com.ltnc.JavaApp.Service.MedicalDetailService.Interface;

import com.ltnc.JavaApp.Model.MedicalDetail;

public interface ICreateMedicalDetailService {
    public String createMedicalDetail(MedicalDetail newmedicaldetail,String patientId,String doctorId);
}
