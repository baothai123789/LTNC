package com.ltnc.JavaApp.Service.ScheduleService.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IAddScheduleService;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IFindDoctorbyMajorService;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IGetDoctorScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
@Component
public class PatientScheduleService implements IFindDoctorbyMajorService, IGetDoctorScheduleService, IAddScheduleService {
    @Autowired
    ScheduleRepository repository;
    @Autowired
    DoctorRepository doctorRepository;

    private List<Schedule> getDoctorSchedulebyDate(String doctorid,LocalDate date){
        return repository.findbyDateandDoctor(date, doctorid);
    }
    @Override
    public String addSchedule(Schedule newSchedule){
        newSchedule.setId(UUID.randomUUID().toString());
        try{
            repository.save(newSchedule);
        }
        catch (Exception e){
            MyApp.LOGGER.info(e.getMessage());
            return "fail";
        }
        return "success";
    }
    @Override
    public List<Integer> getDoctorSchedule(String doctorid,LocalDate date){
        List<Schedule> schedules = getDoctorSchedulebyDate(doctorid,date);
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
        return IntStream.range(1,24).boxed().filter(i->Arrays.asList(time).get(i)).toList();

    }

    @Override
    public List<Doctor> findDoctor(String major) {
        return doctorRepository.findByMajor(major);
    }
}
