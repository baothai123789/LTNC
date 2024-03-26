package com.ltnc.JavaApp.Service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;


import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Repository.DoctorRepository;

public class DoctorInformationService implements IInfomationService {
    @Autowired
    DoctorRepository repository;


    public Optional<Person> getData(String id){
        return  repository.findById(id).map(Person.class::cast);
    }
}
