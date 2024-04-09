package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.MedicalDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalDetailRepository extends MongoRepository<MedicalDetail,String> {
 }
