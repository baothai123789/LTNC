package com.ltnc.JavaApp.Service;

import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
@Component
public class ScheduleService {
    @Autowired
    ScheduleRepository repository;

    public List<Schedule> getDoctorSchedule(String doctorid,LocalDate date){
        return repository.findbyDateandDoctor(date, doctorid);
    }
    public void addSchedule(Schedule newSchedule){
        newSchedule.setId(UUID.randomUUID().toString());
        repository.save(newSchedule);
    }
    public List<Boolean> getFreetime(List<Schedule> schedules){
        Boolean[] time = new Boolean[24];
        Arrays.fill(time,true);
        for(int i=0;i<8;++i){
            time[i]=false;
        }
        for(int i = 16; i<24;i++){
            time[i]=false;
        }
        for(Schedule schedule:schedules){
            time[schedule.getTime()]=false;
        }
        return Arrays.asList(time);
    }

}
