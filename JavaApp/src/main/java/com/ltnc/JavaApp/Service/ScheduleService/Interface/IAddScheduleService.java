package com.ltnc.JavaApp.Service.ScheduleService.Interface;

import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.Schedule;

public interface IAddScheduleService{
    public void addSchedule(ScheduleModel scheduleModel, Schedule newSchedule) throws NullPointerException;
}
