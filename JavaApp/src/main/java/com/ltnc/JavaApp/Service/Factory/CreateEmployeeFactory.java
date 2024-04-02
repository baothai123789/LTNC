package com.ltnc.JavaApp.Service.Factory;

import com.ltnc.JavaApp.Service.IEmployeeCreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

enum Employee{
    Doctor,Nurse,Functionalemployee
}
@Component
public class CreateEmployeeFactory {
    @Autowired
    private List<IEmployeeCreateUserService> services;

    private static final EnumMap<Employee,String> serviceType = new EnumMap<>(Map.of(
            Employee.Doctor,"DoctorCreateUserService",
            Employee.Nurse,"NurseCreateUserService"
    ));
    public Optional<IEmployeeCreateUserService> getService(String type){
        return services.stream().filter(service->service.getClass()
                        .getSimpleName().equalsIgnoreCase(serviceType.get(Employee.valueOf(type))))
                        .findFirst();
    }
}
