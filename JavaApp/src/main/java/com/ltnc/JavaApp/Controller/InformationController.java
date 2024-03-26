package com.ltnc.JavaApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltnc.JavaApp.Service.IInfomationService;
import com.ltnc.JavaApp.Service.InformationServiceFactory;
import com.ltnc.JavaApp.Model.Person;
import java.util.Optional;
@RestController
@RequestMapping("/info")
public class InformationController {
    @Autowired
    private IInfomationService service;

    @Autowired
    private InformationServiceFactory serviceFactory;

    @GetMapping("/{type}")
    Optional<Person> getInfomation(@PathVariable("type") String type){
        return serviceFactory.getInfomationService(type).get().getData(type);
    }
}

