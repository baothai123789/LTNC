package com.ltnc.JavaApp.RequestModel.ScheduleRequestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientScheduleRequest {
    private String doctorId;
    private String patientId;
    LocalDate date;
    Integer startTime;
}
