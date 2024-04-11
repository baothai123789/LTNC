package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialEmployeeRepository extends MongoRepository<FinancialEmployee,String> {
}
