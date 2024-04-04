package com.ltnc.JavaApp.Service.Factory;

import com.ltnc.JavaApp.Service.IEmployeeCreateUserService;



import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;


enum Employee{
    doctor,nurse,Functionalemployee
}
@Component
public class CreateEmployeeFactory extends FactoryAbtract<IEmployeeCreateUserService> {
    public CreateEmployeeFactory(){
        super.serviceType = new EnumMap<>(Map.of(
            Employee.doctor,"DoctorCreateUserService",
            Employee.nurse,"NurseCreateUserService"
        ));
    }
}
