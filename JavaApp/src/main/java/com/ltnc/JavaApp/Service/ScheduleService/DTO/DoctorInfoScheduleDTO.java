package com.ltnc.JavaApp.Service.ScheduleService.DTO;

import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.DoctorInfoDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DoctorInfoScheduleDTO {
    DoctorInfoDTO doctorInfo;
    List<DoctorScheduleForPatientChoiceDTO> doctorScheduleDTOs;
}
