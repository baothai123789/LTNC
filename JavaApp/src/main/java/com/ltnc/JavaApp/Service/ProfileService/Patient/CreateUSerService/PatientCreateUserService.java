package com.ltnc.JavaApp.Service.ProfileService.Patient.CreateUSerService;

import com.ltnc.JavaApp.Model.NotificationList;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.PatientRepository;


import java.util.UUID;

import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientCreateUserService implements IPatientCreateUserService {
    @Resource
    private PatientRepository repository;
    public void createUser(Patient newpatient){
        newpatient.setId(UUID.randomUUID().toString());
        repository.save(newpatient);
    }

}
