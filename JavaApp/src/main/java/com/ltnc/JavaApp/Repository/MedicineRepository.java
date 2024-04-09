package com.ltnc.JavaApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicineRepository extends MongoRepository<MedicineRepository,String>{
}
