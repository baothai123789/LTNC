package com.ltnc.JavaApp.Repository;


import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BenhnhanRepository extends MongoRepository<Doctor,String>{
}