package com.ltnc.JavaApp.Service.CreateUserService.Factory;

import com.ltnc.JavaApp.Service.CreateUserService.Employee.Interface.IEmployeeCreateUserService;


import com.ltnc.JavaApp.Service.Factory.Employee;
import com.ltnc.JavaApp.Service.Factory.FactoryAbtract;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;


@Component
public class CreateEmployeeFactory extends FactoryAbtract<IEmployeeCreateUserService> {
    public CreateEmployeeFactory(){
        super.serviceType = new EnumMap<>(Map.of(
            Employee.doctor,"DoctorCreateUserService",
            Employee.nurse,"NurseCreateUserService"
        ));
    }
}
