package com.ltnc.JavaApp.Service.InformationService.Service;

import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Service.InformationService.Interface.IInfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

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
