package com.ltnc.JavaApp.Service.ScheduleService.Interface;

import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.ScheduleDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IGetScheduleService {
    public List<ScheduleDTO> getSchedules(String modelId) throws NullPointerException;
    public List<ScheduleDTO> getSchedules(String modelId,LocalDate date) throws NullPointerException;
    public String getType();
}
