package com.ltnc.JavaApp.Service.ProfileService.CreateUserService.Patient.Service;

import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.PatientRepository;


import java.util.UUID;

import com.ltnc.JavaApp.Service.ProfileService.CreateUserService.Patient.Interface.IPatientCreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientCreateUserService implements IPatientCreateUserService {
    @Autowired
    private PatientRepository repository;

    public String createUser(Patient newpatient){
        newpatient.setId(UUID.randomUUID().toString());
        try {
            repository.save(newpatient);
        }
        catch (Exception e){
            return "Fail";
        }
        return "Success";
    }

}
