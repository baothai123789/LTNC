package com.ltnc.JavaApp.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ltnc.JavaApp.Model.Schedule;

public interface ScheduleRepository extends MongoRepository<Schedule,String> {
    @Query("{'$and':[{'date':{$eq:?0}},{'doctor':?1}]}")
    List<Schedule> findbyDateandDoctor(LocalDate date,String doctorid);
}
