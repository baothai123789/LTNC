package com.ltnc.JavaApp.Service.MedicalDetailService.DTO;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.PatientInfoDTo;
import org.springframework.stereotype.Component;

@Component
public class DoctorMedicalDetailDTOMapper implements IMedicalDetailDTOMapper{
    public IMedicalDetailDTO map(MedicalDetail medicalDetail, Doctor doctor, Patient patient){
        return DoctorMedicalDetailDTO.builder()
                .id(medicalDetail.getId())
                .date(medicalDetail.getDate())
                .major(medicalDetail.getMajor())
                .inProgress(medicalDetail.isInProgress())
                .nameofDisease(medicalDetail.getNameofDisease())
                .PatientState(medicalDetail.getPatientState())
                .prescription(medicalDetail.getPrescription())
                .medicalSchedules(medicalDetail.getMedicalSchedules())
                .patientInfo(new PatientInfoDTo(patient))
                .build();
    }

    @Override
    public String getType() {
        return "doctor";
    }
}
