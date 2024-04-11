package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface HospitalAdmissionDetailRepository extends MongoRepository<HospitalAdmissionDetail,String>{
    @Query("{'$and': [{'_id':?0},{'done': ?1}]}")
    public List<HospitalAdmissionDetail> getHospitalAdmissionDetailsByDone(String id,Boolean done);

}
