package com.ltnc.JavaApp.Service.CreateUserService.Employee.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Repository.DoctorRepository;


import java.util.UUID;

import com.ltnc.JavaApp.Service.CreateUserService.Employee.Interface.IEmployeeCreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorCreateUserService implements IEmployeeCreateUserService {
    @Autowired
    private DoctorRepository repository;
    public String createUser(Employee newemployee){
        newemployee.setId(UUID.randomUUID().toString());
        try {
            repository.save((Doctor) newemployee);
        }
        catch (Exception e){
            return "Fail";
        }
        return "Success";
    }
}
