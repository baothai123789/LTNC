package com.ltnc.JavaApp.Service.ScheduleService.DTO;

import com.ltnc.JavaApp.Model.Doctor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class PatientScheduleDTO {
    private String id;
    private Integer time;
    private LocalDate date;
    private String doctorId;
}
