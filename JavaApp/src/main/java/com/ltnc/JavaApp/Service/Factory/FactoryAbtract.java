package com.ltnc.JavaApp.Service.Factory;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ltnc.JavaApp.Service.IEmployeeCreateUserService;
@Component
public abstract class  FactoryAbtract<T> {
    @Autowired
    List<T> services;
    protected EnumMap<Employee, String> serviceType;
    public Optional<T> getService(String type){
        return services.stream().filter(service->service.getClass()
                        .getSimpleName().equalsIgnoreCase(serviceType.get(Employee.valueOf(type))))
                        .findFirst();
    }

}
