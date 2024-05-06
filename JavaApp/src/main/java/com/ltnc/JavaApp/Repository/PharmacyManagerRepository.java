package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.PharmacyEquipmentManager;
import com.ltnc.JavaApp.Model.PharmacyManager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyManagerRepository extends MongoRepository<PharmacyManager,String>{
}
