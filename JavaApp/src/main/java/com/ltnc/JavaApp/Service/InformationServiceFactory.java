package com.ltnc.JavaApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

enum User{
    Patient,Doctor
}

@Component
public class InformationServiceFactory {
    @Autowired
    private List<IInfomationService> services;

    public Optional<IInfomationService> getInfomationService(String type){
        return services.stream().filter(service->service.getClass().getName().equalsIgnoreCase(type)).findFirst();
    }

}
