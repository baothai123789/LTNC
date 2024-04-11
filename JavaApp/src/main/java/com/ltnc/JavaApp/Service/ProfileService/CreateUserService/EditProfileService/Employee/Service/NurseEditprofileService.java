package com.ltnc.JavaApp.Service.ProfileService.CreateUserService.EditProfileService.Employee.Service;

import java.util.Optional;
import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Service.ProfileService.CreateUserService.EditProfileService.Employee.Interface.IEmployeeEditProfileService;
import com.ltnc.JavaApp.Service.InformationService.Interface.IInfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Repository.NurseRepository;
import com.ltnc.JavaApp.Service.InformationService.Factory.InformationServiceFactory;


@Component
public class NurseEditprofileService implements IEmployeeEditProfileService {
    @Autowired
    private InformationServiceFactory informationServiceFactory;
    
    @Autowired
    private NurseRepository repository;

    @Override
    public String editProfile(String userid,Employee newprofile){
        
       Optional<IInfomationService> infoservice=informationServiceFactory.getInfomationService(newprofile.getRole());
       if(infoservice.isEmpty()) return "Method not found";
       Optional<Person> employee = infoservice.get().getData(userid);
       if(employee.isEmpty()) return "user not found";
       try{
        repository.save((Nurse)newprofile);
       }                            
       catch(Exception e){
        return "fail";
       }
       return "success";                                                     
    }
}
