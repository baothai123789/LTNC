package com.ltnc.JavaApp.Service.ScheduleService.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorScheduleDTO {
    private Integer startTime;
    private Integer endTime;

}
