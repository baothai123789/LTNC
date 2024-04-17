package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.MaintenanceHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MaintenanceHistoryRepository extends MongoRepository<MaintenanceHistory,String> {
    List<MaintenanceHistory> findByDateBetween(LocalDate startOfMonth, LocalDate endOfMonth);

}
