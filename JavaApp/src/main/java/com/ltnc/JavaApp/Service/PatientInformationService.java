package com.ltnc.JavaApp.Service;

import com.ltnc.JavaApp.MyApp;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.logging.Logger;

import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Repository.PatientRepository;
import org.springframework.stereotype.Component;

@Component
public class PatientInformationService implements IInfomationService {
    @Autowired
    private PatientRepository repository;


    public Optional<Person> getData(String id){
        MyApp.LOGGER.info("Patient info service created");
        Optional<Person> res=repository.findById(id).map(Person.class::cast);
        MyApp.LOGGER.info(res);
        return res;

    }
}
