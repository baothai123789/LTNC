package com.ltnc.JavaApp.Service.ScheduleService.Factory;

import com.ltnc.JavaApp.Service.Factory.User;
import com.ltnc.JavaApp.Service.Factory.FactoryAbtract;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IScheduleManageService;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class ScheduleManageServiceFactory extends FactoryAbtract<IScheduleManageService> {
    public ScheduleManageServiceFactory(){
        super.serviceType = new EnumMap<>(Map.of(
                User.doctor,"DoctorScheduleMangeService",
                User.patient,"PatientScheduleMangeService"
        ));
    }
}
