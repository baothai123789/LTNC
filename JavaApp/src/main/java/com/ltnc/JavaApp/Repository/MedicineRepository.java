package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MedicineRepository extends MongoRepository<Medicine,String>{
    @Query("{'name': ?0}")
    List<Medicine> findByName(String name);
}
