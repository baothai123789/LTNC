package com.ltnc.JavaApp.Service.Factory;

import java.util.EnumMap;
import java.util.Map;
import org.springframework.stereotype.Component;

import com.ltnc.JavaApp.Service.IEmployeeEditProfileService;

@Component
public class EditprofileServiceFactory extends FactoryAbtract<IEmployeeEditProfileService> {
    public EditprofileServiceFactory(){
        super.serviceType = new EnumMap<>(Map.of(
            Employee.doctor,"DoctorEditProfileService",
            Employee.nurse,"NurseEditProfileService"
        ));
    }
}
