package com.ltnc.JavaApp.Service.ScheduleService.DTO;

import com.ltnc.JavaApp.Model.Doctor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PatientScheduleDTO {
    private String id;
    private Integer time;
    private LocalDate date;
    private DoctorInfoDTO doctorInfo;
}
