package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.MedicalDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface MedicalDetailRepository extends MongoRepository<MedicalDetail,String> {
}
