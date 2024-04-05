package com.ltnc.JavaApp.Service;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.PharmacyManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PharmacyManagerCreateUserService implements IEmployeeCreateUserService{
    @Autowired
    private PharmacyManagerRepository repository;

    @Override
    public String createUser(Employee newemployee){
        newemployee.setId(UUID.randomUUID().toString());
        try {
            repository.save((PharmacyManager) newemployee);
        }
        catch (Exception e){
            return "Fail";
        }
        return "Success";
    }
}
