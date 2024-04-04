package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface PresciptionRepository extends MongoRepository<Prescription,String> {
}
