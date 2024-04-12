package com.ltnc.JavaApp.Service.ProfileService.Employee.EditUserService;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorEditUserService extends AbstractEditUserService<Doctor>{
    @Autowired
    public DoctorEditUserService(DoctorRepository doctorRepository){
        this.modelRepository = doctorRepository;
        this.type=Doctor.class;
    }
}
