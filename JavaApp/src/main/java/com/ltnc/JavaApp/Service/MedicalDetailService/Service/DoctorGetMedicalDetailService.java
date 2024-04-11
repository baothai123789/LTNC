package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Service.ScheduleService.Service.AbstractGetScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorGetMedicalDetailService extends AbstractGetMedicalDetailService<Doctor> {
    @Autowired
    public DoctorGetMedicalDetailService(MongoRepository<Doctor, String> doctorMongoRepository, MedicalDetailRepository medicalDetailRepository ) {
        this.medicalDetailRepository=medicalDetailRepository;
        this.modelRepository=doctorMongoRepository;
        this.type = Doctor.class;
    }
}
