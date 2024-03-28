package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.MedicalEquipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface MedicalEquipmentRepository extends MongoRepository<MedicalEquipment,String> {
}
