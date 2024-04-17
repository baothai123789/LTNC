package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.MaintenanceHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceHistoryRepository extends MongoRepository<MaintenanceHistory,String> {
}
