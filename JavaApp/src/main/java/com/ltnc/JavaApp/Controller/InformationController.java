package com.ltnc.JavaApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ltnc.JavaApp.Service.InformationService.Interface.IInfomationService;
import com.ltnc.JavaApp.Service.InformationService.Factory.InformationServiceFactory;
import com.ltnc.JavaApp.Model.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@RestController
@RequestMapping("/info")
public class InformationController {


    @Autowired
    private InformationServiceFactory serviceFactory;
    @GetMapping("/{type}/{id}")
    @ResponseBody
    ResponseEntity<Object> getInfomation(@PathVariable("type")String type, @PathVariable("id") String id) {
        Optional<IInfomationService> service = serviceFactory.getInfomationService(type);
        Optional<Person> user =service.flatMap(iInfomationService -> iInfomationService.getData(id));
        return user.<ResponseEntity<Object>>map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new HashMap<>(Map.of("message","User not found")), HttpStatus.NOT_FOUND));
    }
    }



