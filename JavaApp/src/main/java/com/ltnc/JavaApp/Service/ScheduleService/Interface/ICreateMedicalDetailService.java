package com.ltnc.JavaApp.Service.ScheduleService.Interface;

import com.ltnc.JavaApp.Model.MedicalDetail;

public interface ICreateMedicalDetailService {
    public void createMedicalDetail(MedicalDetail medicalDetail,String doctorId,String patientId);
}
