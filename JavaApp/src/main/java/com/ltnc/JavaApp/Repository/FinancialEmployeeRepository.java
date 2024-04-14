package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialEmployeeRepository extends MongoRepository<FinancialEmployee,String> {
    public FinancialEmployee findByDoctor(Doctor doctor);
    public FinancialEmployee findByNurse(Nurse nurse);
    public FinancialEmployee findByPharmacyManager(PharmacyManager pharmacyManager);
    public FinancialEmployee findByPatient(Patient patient);
}
