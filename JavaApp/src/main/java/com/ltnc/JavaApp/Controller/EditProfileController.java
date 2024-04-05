package com.ltnc.JavaApp.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Service.EditProfileService.Employee.Interface.IEmployeeEditProfileService;
import com.ltnc.JavaApp.Service.EditProfileService.Patient.Interface.IPatientEditProfileService;
import com.ltnc.JavaApp.Service.EditProfileService.Factory.EditprofileServiceFactory;

@RestController
@RequestMapping("/editprofile")
public class EditProfileController {
    @Autowired
    private IPatientEditProfileService service;
    @Autowired 
    private EditprofileServiceFactory servicefactory;
    @PutMapping("/patient/{id}")
    ResponseEntity<Map<String,String>> editPatientProfile(@PathVariable(value = "id") String userid,@RequestBody Patient newprofile){
        String message=service.editProfile(userid, newprofile);
        if(message.equalsIgnoreCase("success")){
            return new ResponseEntity<>(new HashMap<>(Map.of("message",message)),HttpStatus.OK);
        }
        else if( message.equalsIgnoreCase("not found user")){
            return new ResponseEntity<>(new HashMap<>(Map.of("message",message)),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new HashMap<>(Map.of("mesage","fail")),HttpStatus.NOT_ACCEPTABLE);                                                                        
        }
    }
    @PutMapping("/employee/{id}")
    ResponseEntity<Map<String,String>> editEmployeeProfile(@PathVariable(value = "id") String userid,@RequestBody Employee newprofile){
        Optional<IEmployeeEditProfileService> service = servicefactory.getService(newprofile.getRole());

        String message;
        if(service.isPresent()){
            message=service.get().editProfile(userid,newprofile);
            return message.equalsIgnoreCase("Success") ?new ResponseEntity<>(new HashMap<>(Map.of("message",message)),HttpStatus.OK):
                    new ResponseEntity<>(new HashMap<>(Map.of("message",message)),HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(new HashMap<>(Map.of("message","Service not found")),HttpStatus.NOT_FOUND);
        }
    }

}
