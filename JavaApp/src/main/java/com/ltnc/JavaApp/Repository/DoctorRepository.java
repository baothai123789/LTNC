package com.ltnc.JavaApp.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import com.ltnc.JavaApp.Model.Doctor;
@Component
public interface DoctorRepository extends MongoRepository<Doctor,String> {
    @Query("{'major':?0}")
    List<Doctor> findByMajor(String major);
}
