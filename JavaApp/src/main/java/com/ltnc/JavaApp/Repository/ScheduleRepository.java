package com.ltnc.JavaApp.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ltnc.JavaApp.Model.Schedule;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule,String> {
    @Query("{'$and': [{'_id': ?0},{'date':?1 }]}")
    public List<Schedule> findbyDateandId(String id,LocalDate date);
}
