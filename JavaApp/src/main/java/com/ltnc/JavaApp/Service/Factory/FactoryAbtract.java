package com.ltnc.JavaApp.Service.Factory;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class  FactoryAbtract<T> {
    @Autowired
    List<T> services;
    protected EnumMap<User, String> serviceType;
    public Optional<T> getService(String type){
        return services.stream().filter(service->service.getClass()
                        .getSimpleName().equalsIgnoreCase(serviceType.get(User.valueOf(type))))
                        .findFirst();
    }

}
