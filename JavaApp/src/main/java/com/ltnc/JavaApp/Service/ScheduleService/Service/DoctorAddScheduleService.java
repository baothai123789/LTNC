package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;



@Service
public class DoctorAddScheduleService extends AbstractAddScheduleService<Doctor>{
    @Autowired
    public DoctorAddScheduleService(MongoRepository<Doctor,String> repository, ScheduleRepository scheduleRepository){
        this.repository=repository;
        this.type=Doctor.class;
        this.scheduleRepository=scheduleRepository;
    }
}


