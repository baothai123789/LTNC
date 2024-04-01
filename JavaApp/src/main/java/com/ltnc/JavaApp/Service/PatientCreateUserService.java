package com.ltnc.JavaApp.Service;

import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientCreateUserService implements IPatientCreateUserService {
    @Autowired
    private PatientRepository repository;

    public String createUser(Patient newpatient){
        try {
            repository.save(newpatient);
        }
        catch (Exception e){
            return "Fail";
        }
        return "Success";
    }

}
