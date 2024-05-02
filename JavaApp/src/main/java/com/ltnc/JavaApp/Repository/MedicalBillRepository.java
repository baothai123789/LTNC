package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.MedicalBill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalBillRepository extends MongoRepository<MedicalBill,String>{
    @Query("{'$and': [{'id':?0},{'paid': ?1}]}")
    public List<MedicalBill> findMedicalBillByPaid(String id, Boolean paid);
    @Query("{'patient': ?0}")
    public List<MedicalBill> findPatientMedicalBill(String patientId);
}
