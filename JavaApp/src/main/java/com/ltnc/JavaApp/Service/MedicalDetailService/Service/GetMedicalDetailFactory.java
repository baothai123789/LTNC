package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetMedicalDetailFactory {
    @Autowired
    List<IGetMedicalDetailService> getMedicalDetailServiceList;
    public IGetMedicalDetailService getMedicalDetailService(String type){
        return getMedicalDetailServiceList.stream()
                .filter(service->service.getType()
                        .equalsIgnoreCase(type)).findFirst().orElseThrow(()->new NullPointerException("service not found"));
    }

}
