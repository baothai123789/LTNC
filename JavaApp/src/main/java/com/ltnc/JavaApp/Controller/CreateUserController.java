package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Employee;
<<<<<<< HEAD
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Service.ProfileService.CreateUserService.Factory.CreateEmployeeFactory;
import com.ltnc.JavaApp.Service.ProfileService.CreateUserService.Employee.Interface.IEmployeeCreateUserService;
import com.ltnc.JavaApp.Service.ProfileService.CreateUserService.Patient.Service.PatientCreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

>>>>>>> c7f46f9da7b8b3b0748f1931574a012568911c0f
import java.util.Optional;

@RestController
@RequestMapping("/create")
public class CreateUserController {
    @Autowired
    private PatientCreateUserService service;

    @Autowired
    private CreateEmployeeFactory createemployeefactory;

<<<<<<< HEAD
    @PostMapping("/patient")
    Map<String,String> createPatient(@RequestBody Patient newpatient){
        String message=service.createUser(newpatient);
        Map<String,String> response = new HashMap<>();
        response.put("message",message);
        return response;
    }
    @PostMapping("/employee/{type}")
    ResponseEntity<Map<String,String>> createEmployee(@RequestBody Employee newemployee, @PathVariable String type){
        Optional<IEmployeeCreateUserService> service = createemployeefactory.getService(type);
=======
    @PostMapping("/employee")
    ResponseEntity<Map<String,String>> createFuntionalEmployee(@RequestBody Employee newemployee){
        Optional<IEmployeeCreateUserService> service = createemployeefactory.getService(newemployee.getRole());
>>>>>>> c7f46f9da7b8b3b0748f1931574a012568911c0f
        String message;
        if(service.isPresent()){
            message=service.get().createUser(newemployee);
            return message.equalsIgnoreCase("Success") ?new ResponseEntity<>(new HashMap<>(Map.of("message",message)),HttpStatus.OK):
                    new ResponseEntity<>(new HashMap<>(Map.of("message",message)),HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(new HashMap<>(Map.of("message","Service not found")),HttpStatus.NOT_FOUND);
        }
<<<<<<< HEAD

    }
}
=======
    }

}
>>>>>>> c7f46f9da7b8b3b0748f1931574a012568911c0f
