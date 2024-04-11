package com.ltnc.JavaApp.Service.ProfileService.CreateUserService.Factory;
import com.ltnc.JavaApp.Service.IInfomationService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;



@Component
public class InformationServiceFactory {
    @Autowired
    private List<IInfomationService> services;

    private static final EnumMap<,String> serviceType = new EnumMap<>(Map.of(
            User.patient,"PatientInformationService",User.doctor,"DoctorInformationService"));
    public Optional<IInfomationService> getInfomationService(String type){
        return services.stream().filter(service->service.getClass()
                        .getSimpleName().equalsIgnoreCase(serviceType.get(User.valueOf(type.toLowerCase()))))
                .findFirst();
    }

}