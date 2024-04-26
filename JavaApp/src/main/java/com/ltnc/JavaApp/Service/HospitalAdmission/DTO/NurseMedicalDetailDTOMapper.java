package com.ltnc.JavaApp.Service.HospitalAdmission.DTO;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.DoctorMedicalDetailDTO;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.IMedicalDetailDTO;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.NurseMedicalDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class NurseMedicalDetailDTOMapper {
    public IMedicalDetailDTO map(MedicalDetail medicalDetail){
        return NurseMedicalDetailDTO.builder()
                .id(medicalDetail.getId())
                .date(medicalDetail.getDate())
                .major(medicalDetail.getMajor())
                .inProgress(medicalDetail.isInProgress())
                .nameofDisease(medicalDetail.getNameofDisease())
                .PatientState(medicalDetail.getPatientState())
                .prescription(medicalDetail.getPrescription())
                .medicalSchedules(medicalDetail.getMedicalSchedules())
                .build();
    }
}
