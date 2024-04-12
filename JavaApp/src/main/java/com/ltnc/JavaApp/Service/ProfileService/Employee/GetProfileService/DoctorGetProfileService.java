package com.ltnc.JavaApp.Service.ProfileService.Employee.GetProfileService;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorGetProfileService extends AbstractGetProfileService<Doctor>{
    @Autowired
    public DoctorGetProfileService(DoctorRepository doctorRepository){
        this.modelRepository = doctorRepository;
        this.type = Doctor.class;
    }
}
