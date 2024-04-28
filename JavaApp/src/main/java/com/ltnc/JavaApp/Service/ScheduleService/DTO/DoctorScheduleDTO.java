package com.ltnc.JavaApp.Service.ScheduleService.DTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
public class DoctorScheduleDTO extends ScheduleDTO{
    private PatientInfoDTO patientInfo;
}
