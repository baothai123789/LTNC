package com.ltnc.JavaApp.Service.MedicalDetailService.DTO;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import com.mongodb.lang.Nullable;

public interface IMedicalDetailDTOMapper {
    public IMedicalDetailDTO map(MedicalDetail medicalDetail, @Nullable Doctor doctor, @Nullable Patient patient);
    public String getType();
}
