package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Service.MedicalDetailService.Service.MedicalDetailManageService;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.ICreateMedicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateMedicalDetailService implements ICreateMedicalDetailService {
    @Autowired
    private MedicalDetailManageService medicalDetailManageService;

    @Override
    public void createMedicalDetail(MedicalDetail medicalDetail, String doctorId, String patientId) throws NullPointerException {
        medicalDetail.setId(UUID.randomUUID().toString());
        medicalDetail.setDoctorId(doctorId);
        medicalDetail.setPatientId(patientId);
        try {
            this.medicalDetailManageService.addMedicalDetail(medicalDetail, doctorId, "doctor");
            this.medicalDetailManageService.addMedicalDetail(medicalDetail, patientId, "patient");
        }
        catch (NullPointerException e) {
            throw  new NullPointerException("user not found");
        }
    }



}
