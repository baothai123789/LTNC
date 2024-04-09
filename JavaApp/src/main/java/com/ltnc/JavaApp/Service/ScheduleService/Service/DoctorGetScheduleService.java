package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorGetScheduleService extends AbstractGetScheduleService<Doctor> {
    @Autowired
    public DoctorGetScheduleService(MongoRepository<Doctor,String> repository, ScheduleRepository scheduleRepository){
        this.repository = repository;
        this.scheduleRepository = scheduleRepository;
        this.type=Doctor.class;
    }
}
