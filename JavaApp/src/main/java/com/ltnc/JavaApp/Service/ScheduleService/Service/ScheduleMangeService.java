package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.Schedule;

import com.ltnc.JavaApp.Service.ScheduleService.DTO.ScheduleDTO;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.*;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.List;


@Service
public class ScheduleMangeService implements IScheduleManageService{
    @Resource
    IAddScheduleService addScheduleService;
    @Resource
    List<IGetScheduleService> getScheduleServices;


    public ScheduleMangeService(){}

    @Override
    public void addSchedule(Schedule newschedule,ScheduleModel scheduleModel)throws NullPointerException {
        addScheduleService.addSchedule(scheduleModel,newschedule);
    }

    @Override
    public List<ScheduleDTO> getSchedules(String modelId, String type) {
        IGetScheduleService getScheduleService=getScheduleServices
                .stream().filter(service->service.getType().equalsIgnoreCase(type)).findFirst()
                .orElseThrow(NullPointerException::new);
        return getScheduleService.getSchedules(modelId);
    }
    @Override
    public List<ScheduleDTO> getSchedulesbyDate(String modelId, LocalDate date,String type) {
        IGetScheduleService getScheduleService=getScheduleServices
                .stream().filter(service->service.getType().equalsIgnoreCase(type)).findFirst()
                .orElseThrow(NullPointerException::new);
        return getScheduleService.getSchedules(modelId,date);
    }
}
