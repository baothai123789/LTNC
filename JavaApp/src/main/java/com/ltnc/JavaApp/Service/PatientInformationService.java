package com.ltnc.JavaApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Repository.PatientRepository;

public class PatientInformationService implements IInfomationService {
    @Autowired
    private PatientRepository repository;


    public Optional<Person> getData(String id){
        return repository.findById(id).map(Person.class::cast);
    }
}
