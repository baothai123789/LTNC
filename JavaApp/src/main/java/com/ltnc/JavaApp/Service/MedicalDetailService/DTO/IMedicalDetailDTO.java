package com.ltnc.JavaApp.Service.MedicalDetailService.DTO;

import com.ltnc.JavaApp.Model.MedicalSchedule;
import com.ltnc.JavaApp.Model.Prescription;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.DoctorInfoDTO;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.PatientInfoDTo;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder(toBuilder = true)
public abstract class IMedicalDetailDTO {
    protected String id;
    protected String major;
    protected String nameofDisease;
    protected String PatientState;
    protected boolean inProgress;
    protected Prescription prescription;
    protected List<MedicalSchedule> medicalSchedules;
    protected LocalDate date;
}
