package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
class DoctorRemoveScheduleService extends AbstractRemoveScheduleService<Doctor>{
    @Autowired
    public DoctorRemoveScheduleService(MongoTemplate mongoTemplate){
        this.mongoTemplate=mongoTemplate;
        this.type=Doctor.class;
    }

}
