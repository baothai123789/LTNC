package com.ltnc.JavaApp.Service.ScheduleService.Interface;

import com.ltnc.JavaApp.Model.Schedule;

import java.time.LocalDate;
import java.util.List;

public interface IScheduleManageService {
    public void addSchedule(Schedule newschedule,String modelId);
    public void removeSchedule(String schedule,String modelId);
    public List<Schedule> getSchedules(String modelId);
    public List<Schedule> getSchedulesbyDate(String modelId, LocalDate date);
}
