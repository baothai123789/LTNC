package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class PatientRemoveScheduleService extends AbstractRemoveScheduleService<Patient>{
    @Autowired
    public PatientRemoveScheduleService(MongoTemplate mongoTemplate){
        this.mongoTemplate=mongoTemplate;
        this.type = Patient.class;
    }
}
