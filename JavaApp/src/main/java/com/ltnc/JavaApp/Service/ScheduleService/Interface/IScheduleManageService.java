package com.ltnc.JavaApp.Service.ScheduleService.Interface;

import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.ScheduleDTO;

import java.time.LocalDate;
import java.util.List;

public interface IScheduleManageService{
    void addSchedule(Schedule newschedule,ScheduleModel scheduleModel);
    List<ScheduleDTO> getSchedules(String modelId, String type);
    List<ScheduleDTO> getSchedulesbyDate(String modelId, LocalDate date,String type);

}
