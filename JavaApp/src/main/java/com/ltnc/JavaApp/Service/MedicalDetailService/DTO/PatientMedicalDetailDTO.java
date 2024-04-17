package com.ltnc.JavaApp.Service.MedicalDetailService.DTO;

import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.DoctorInfoDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
public class PatientMedicalDetailDTO extends IMedicalDetailDTO{
    private DoctorInfoDTO doctorInfo;
}
