package com.ltnc.JavaApp.Service.InformationService.Service;
import com.ltnc.JavaApp.MyApp;
import java.util.Optional;


import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Service.InformationService.Interface.IInfomationService;
import org.springframework.beans.factory.annotation.Autowired;


import com.ltnc.JavaApp.Model.Person;
import org.springframework.stereotype.Component;

@Component
public class DoctorInformationService implements IInfomationService {
    @Autowired
    DoctorRepository repository;


    public Optional<Person> getData(String id){
        MyApp.LOGGER.info("Doctor info service created");
        Optional<Person> res =repository.findById(id).map(Person.class::cast);
        MyApp.LOGGER.info(res);
        return res;
    }
}
