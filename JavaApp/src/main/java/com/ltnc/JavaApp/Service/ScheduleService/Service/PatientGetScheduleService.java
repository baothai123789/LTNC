package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientGetScheduleService extends AbstractGetScheduleService<Patient>{
    @Autowired
    public PatientGetScheduleService(MongoRepository<Patient,String> repository, ScheduleRepository scheduleRepository){
        this.repository=repository;
        this.type=Patient.class;
        this.scheduleRepository=scheduleRepository;
    }
}
