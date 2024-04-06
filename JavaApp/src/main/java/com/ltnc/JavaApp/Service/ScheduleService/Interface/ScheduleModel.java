package com.ltnc.JavaApp.Service.ScheduleService.Interface;

import com.ltnc.JavaApp.Model.Schedule;

import java.util.List;

public interface ScheduleModel {
    public void addSchedule(Schedule newschedule);
    public List<Schedule> getSchedules();
    public void removeSchedule(String scheduleId);
}
