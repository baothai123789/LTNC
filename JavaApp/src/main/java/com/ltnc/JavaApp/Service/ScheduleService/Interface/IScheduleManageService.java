package com.ltnc.JavaApp.Service.ScheduleService.Interface;

import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.Schedule;

import java.time.LocalDate;
import java.util.List;

public interface IScheduleManageService{
    void addSchedule(Schedule newschedule,ScheduleModel scheduleModel);
    List<Schedule> getSchedules(String modelId,String type);
    List<Schedule> getSchedulesbyDate(String modelId, LocalDate date,String type);

}
