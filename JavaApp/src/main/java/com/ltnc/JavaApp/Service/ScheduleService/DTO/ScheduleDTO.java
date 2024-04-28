package com.ltnc.JavaApp.Service.ScheduleService.DTO;

import com.ltnc.JavaApp.Model.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public abstract class ScheduleDTO {
    protected String id;
    protected Integer time;
    protected LocalDate date;
}
