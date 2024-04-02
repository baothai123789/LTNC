package com.ltnc.JavaApp.Service;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Repository.NurseRepository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NurseCreateUserService implements IEmployeeCreateUserService {
    @Autowired
    private NurseRepository repository;
    public String createUser(Employee newemployee){
        newemployee.setId(UUID.randomUUID().toString());
        MyApp.LOGGER.info(newemployee.getId());
        try{
            repository.save((Nurse)newemployee );
        }
        catch (Exception e){
            MyApp.LOGGER.info(e.getMessage());
            return "Fail";
        }
        return "Success";
    }
}
