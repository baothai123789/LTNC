package com.ltnc.JavaApp.Service.MedicalDetailService.Interface;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IAddMedicalDetailService {
    public void addMedicalDetail(String doctorId, String patientId, MedicalDetail medicalDetail);
}
