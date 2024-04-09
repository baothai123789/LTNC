package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.Doctor;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepository extends MongoRepository<Doctor,String> {
}
