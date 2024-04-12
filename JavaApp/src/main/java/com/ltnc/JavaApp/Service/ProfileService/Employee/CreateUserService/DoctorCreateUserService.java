package com.ltnc.JavaApp.Service.ProfileService.Employee.CreateUserService;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Service.ProfileService.Employee.CreateUserService.AbstractEmployeeCreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorCreateUserService extends AbstractEmployeeCreateUserService<Doctor> {
    @Autowired
    public DoctorCreateUserService(DoctorRepository doctorRepository){
        this.modelRepository=doctorRepository;
        this.type=Doctor.class;
    }
}
