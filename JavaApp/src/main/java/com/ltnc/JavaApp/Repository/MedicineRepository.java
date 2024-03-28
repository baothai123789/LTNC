package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface MedicineRepository extends MongoRepository<Medicine, String> {
}
