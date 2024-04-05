package com.ltnc.JavaApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface MedicineRepository extends MongoRepository<MedicineRepository,String>{
}
