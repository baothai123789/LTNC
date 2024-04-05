package com.ltnc.JavaApp.Service;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.PharmacyManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PharmacyManagerEditProfileService implements IEmployeeEditProfileService{
    @Autowired
    private InformationServiceFactory infoservicesFactory;

    @Autowired
    private PharmacyManagerRepository repository;

    @Override
    public String editProfile(String userid, Employee newprofile){
        Optional<IInfomationService> infoservice=infoservicesFactory.getInfomationService(newprofile.getRole());
        if(infoservice.isEmpty()) return "Method not found";
        Optional<Person> employee = infoservice.get().getData(userid);
        if(employee.isEmpty()) return "user not found";
        try{
            repository.save((PharmacyManager) newprofile);
        }
        catch(Exception e){
            return "fail";
        }
        return "success";
    }

}
