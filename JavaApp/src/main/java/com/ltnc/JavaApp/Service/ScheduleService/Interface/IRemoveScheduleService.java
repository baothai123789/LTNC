package com.ltnc.JavaApp.Service.ScheduleService.Interface;

import com.ltnc.JavaApp.Model.Schedule;

public interface IRemoveScheduleService {
    public void removeSchedule(String modelId, String scheduleid) throws NullPointerException;
    public String getType();
}
