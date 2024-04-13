package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Model.PharmacyManager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialEmployeeRepository extends MongoRepository<FinancialEmployee,String> {
    FinancialEmployee findByDoctor(Doctor doctor);

    FinancialEmployee findByNurse(Nurse nurse);

    FinancialEmployee findByPharmacyManager(PharmacyManager pharmacyManager);
}
