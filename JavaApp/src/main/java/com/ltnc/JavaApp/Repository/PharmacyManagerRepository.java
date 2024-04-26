package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.PharmacyEquipmentManager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyManagerRepository extends MongoRepository<PharmacyEquipmentManager,String>{
}
