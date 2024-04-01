package com.ltnc.JavaApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import com.ltnc.JavaApp.Model.Doctor;
@Component
public interface DoctorRepository extends MongoRepository<Doctor,String> {
}
