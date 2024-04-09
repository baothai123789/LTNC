package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Schedule;

import com.ltnc.JavaApp.Service.ScheduleService.Interface.*;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.List;


@Service
public class ScheduleMangeService implements IScheduleManageService{
    @Autowired
    List<IAddScheduleService> addScheduleServices;
    @Autowired
    List<IRemoveScheduleService> removeScheduleServices;
    @Autowired
    List<IGetScheduleService> getScheduleServices;


    public ScheduleMangeService(){}

    @Override
    public void addSchedule(Schedule newschedule, String modelId,String type)throws NullPointerException {
        IAddScheduleService addScheduleService=addScheduleServices
                .stream().filter(service->service.getType().equalsIgnoreCase(type)).findFirst()
                .orElseThrow(NullPointerException::new);
        addScheduleService.addSchedule(modelId,newschedule);
    }

    @Override
    public void removeSchedule(String scheduleId, String modelId,String type) {
        IRemoveScheduleService removeScheduleService=removeScheduleServices
                .stream().filter(service->service.getType().equalsIgnoreCase(type)).findFirst()
                .orElseThrow(NullPointerException::new);
        removeScheduleService.removeSchedule(modelId,scheduleId);
    }

    @Override
    public List<Schedule> getSchedules(String modelId,String type) {
        IGetScheduleService getScheduleService=getScheduleServices
                .stream().filter(service->service.getType().equalsIgnoreCase(type)).findFirst()
                .orElseThrow(NullPointerException::new);
        return getScheduleService.getSchedules(modelId);
    }
    @Override
    public List<Schedule> getSchedulesbyDate(String modelId, LocalDate date,String type) {
        IGetScheduleService getScheduleService=getScheduleServices
                .stream().filter(service->service.getType().equalsIgnoreCase(type)).findFirst()
                .orElseThrow(NullPointerException::new);
        return getScheduleService.getSchedules(modelId,date);
    }
}
