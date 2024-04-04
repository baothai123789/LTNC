package com.ltnc.JavaApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Repository.DoctorRepository;

public class FindDoctorbyMajor {
    @Autowired
    DoctorRepository repository;

    public List<Doctor> finDoctors(String major){
        return repository.findByMajor(major);
    }
}
