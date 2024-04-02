package com.ltnc.JavaApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.ltnc.JavaApp.Model.Patient;

@Component
public interface PatientRepository extends MongoRepository<Patient,String>{
}
