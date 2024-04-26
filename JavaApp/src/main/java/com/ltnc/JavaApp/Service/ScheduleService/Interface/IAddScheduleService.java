package com.ltnc.JavaApp.Service.ScheduleService.Interface;

import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.Schedule;

public interface IAddScheduleService{
    public void addSchedule(String modelId, Schedule newSchedule) throws NullPointerException;
    public String getType();
}
