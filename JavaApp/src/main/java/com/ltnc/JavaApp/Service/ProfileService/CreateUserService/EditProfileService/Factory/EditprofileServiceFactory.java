package com.ltnc.JavaApp.Service.ProfileService.CreateUserService.EditProfileService.Factory;

import java.util.EnumMap;
import java.util.Map;

import com.ltnc.JavaApp.Service.Factory.FactoryAbtract;
import com.ltnc.JavaApp.Service.ProfileService.CreateUserService.EditProfileService.Employee.Interface.IEmployeeEditProfileService;
import org.springframework.stereotype.Component;

@Component
public class EditprofileServiceFactory extends FactoryAbtract<IEmployeeEditProfileService> {
    public EditprofileServiceFactory(){
        super.serviceType = new EnumMap<>(Map.of(
            User.doctor,"DoctorEditProfileService",
            User.nurse,"NurseEditProfileService"
        ));
    }
}
