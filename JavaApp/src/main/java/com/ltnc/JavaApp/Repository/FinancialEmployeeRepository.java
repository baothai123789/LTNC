package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FinancialEmployeeRepository extends MongoRepository<FinancialEmployee,String> {
    @Query("{'amountofBillPaid': {'$lt': 10}}")
    Optional<List<FinancialEmployee>> findFinancialEmployeeValid();
}
