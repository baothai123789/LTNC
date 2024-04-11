package com.ltnc.JavaApp.Service.EditProfileService.Factory;

import java.util.EnumMap;
import java.util.Map;

import com.ltnc.JavaApp.Service.Factory.User;
import com.ltnc.JavaApp.Service.Factory.FactoryAbtract;
import org.springframework.stereotype.Component;

import com.ltnc.JavaApp.Service.EditProfileService.Employee.Interface.IEmployeeEditProfileService;

@Component
public class EditprofileServiceFactory extends FactoryAbtract<IEmployeeEditProfileService> {
    public EditprofileServiceFactory(){
        super.serviceType = new EnumMap<>(Map.of(
            User.doctor,"DoctorEditProfileService",
            User.nurse,"NurseEditProfileService"
        ));
    }
}