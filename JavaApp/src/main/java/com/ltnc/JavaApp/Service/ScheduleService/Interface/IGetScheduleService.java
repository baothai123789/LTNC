package com.ltnc.JavaApp.Service.ScheduleService.Interface;

import com.ltnc.JavaApp.Model.Schedule;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IGetScheduleService {
    public List<Schedule> getSchedules(String modelId) throws NullPointerException;
    public List<Schedule> getSchedules(String modelId,LocalDate date) throws NullPointerException;
    public String getType();
}
