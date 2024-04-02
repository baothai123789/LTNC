package com.ltnc.JavaApp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Service.Factory.InformationServiceFactory;

@Component
public class DoctorEditProfileService implements IEmployeeEditProfileService {
    @Autowired
    private InformationServiceFactory infoservicesFactory;

    @Autowired
    DoctorRepository repository;

    @Override
    public String editProfile(String userid,Employee newprofile){
       Optional<IInfomationService> infoservice=infoservicesFactory.getInfomationService(newprofile.getRole()); 
       if(infoservice.isEmpty()) return "Method not found";
       Optional<Person> employee = infoservice.get().getData(userid);
       if(employee.isEmpty()) return "user not found";
       try{
        repository.save((Doctor)newprofile);
       }                            
       catch(Exception e){
        return "fail";
       }
       return "success";                                                     
    }
}
