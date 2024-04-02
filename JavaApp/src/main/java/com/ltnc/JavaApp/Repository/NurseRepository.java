package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.Nurse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NurseRepository extends MongoRepository<Nurse,String> {
}
