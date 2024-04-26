package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.Schedule;

import com.ltnc.JavaApp.Service.ScheduleService.Interface.*;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.List;


@Service
public class ScheduleMangeService implements IScheduleManageService{
    @Autowired
    IAddScheduleService addScheduleService;
    @Autowired
    List<IGetScheduleService> getScheduleServices;


    public ScheduleMangeService(){}

    @Override
    public void addSchedule(Schedule newschedule,ScheduleModel scheduleModel)throws NullPointerException {
        addScheduleService.addSchedule(scheduleModel,newschedule);
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
