package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Service.Factory.CreateEmployeeFactory;
import com.ltnc.JavaApp.Service.IEmployeeCreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/create")
public class CreateUserController {


    @Autowired
    private CreateEmployeeFactory createemployeefactory;

    @PostMapping("/employee")
    ResponseEntity<Map<String,String>> createEmployee(@RequestBody Employee newemployee){
        Optional<IEmployeeCreateUserService> service = createemployeefactory.getService(newemployee.getRole());
        String message;
        if(service.isPresent()){
            message=service.get().createUser(newemployee);
            return message.equalsIgnoreCase("Success") ?new ResponseEntity<>(new HashMap<>(Map.of("message",message)),HttpStatus.OK):
                    new ResponseEntity<>(new HashMap<>(Map.of("message",message)),HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(new HashMap<>(Map.of("message","Service not found")),HttpStatus.NOT_FOUND);
        }
    }

}