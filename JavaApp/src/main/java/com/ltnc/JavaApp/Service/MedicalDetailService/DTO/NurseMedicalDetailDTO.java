package com.ltnc.JavaApp.Service.MedicalDetailService.DTO;

import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.DoctorInfoDTO;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.PatientInfoDTo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
public class NurseMedicalDetailDTO extends IMedicalDetailDTO{
}
