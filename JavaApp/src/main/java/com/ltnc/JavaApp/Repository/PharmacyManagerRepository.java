package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.PharmacyManager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PharmacyManagerRepository extends MongoRepository<PharmacyManager,String>{
    Optional<PharmacyManager> findPharmacyManagerValid();
}
