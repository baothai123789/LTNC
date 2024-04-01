package com.ltnc.JavaApp.Service;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NurseCreateUserService implements IEmployeeCreateUserService {
    @Autowired
    private NurseRepository repository;
    public String createUser(Employee newemployee){
        try{
            repository.save((Nurse)newemployee );
        }
        catch (Exception e){
            return "Fail";
        }
        return "Success";
    }
}
