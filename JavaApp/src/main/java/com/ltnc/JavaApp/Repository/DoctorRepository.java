package com.ltnc.JavaApp.Repository;
import com.ltnc.JavaApp.Model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DoctorRepository extends MongoRepository<Doctor,String> {
    @Query("{'major': ?0}")
    public List<Doctor> findByMajor(String major);
}
