package com.ltnc.JavaApp.Service.ProfileService.CreateUserService.EditProfileService.Patient.Service;

import java.util.Optional;

import com.ltnc.JavaApp.Service.ProfileService.CreateUserService.EditProfileService.Patient.Interface.IPatientEditProfileService;
import com.ltnc.JavaApp.Service.InformationService.Interface.IInfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Service.InformationService.Factory.InformationServiceFactory;
@Component
public class PatientEditProfileService implements IPatientEditProfileService {
    @Autowired
    private InformationServiceFactory infomationservicefac;

    @Autowired
    private PatientRepository repository;

    public String editProfile(String userid,Patient newprofile){
        MyApp.LOGGER.info(userid);
        Optional<IInfomationService> infoservice = infomationservicefac.getInfomationService("patient");
        if(infoservice.isEmpty()) return "method not found";
        Optional<Person> patient = infoservice.get().getData(userid);
        MyApp.LOGGER.info(patient.isPresent());
        if(!patient.isPresent()) return "Not found user"; 
        try{
            repository.save(newprofile);
        }
        catch(Exception e){
            return "Fail";
        }
        return "Success";
    }
}
