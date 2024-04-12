package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.FeeOfPatient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeeOfPatientRepository extends MongoRepository<FeeOfPatient,String> {
}
