package com.ltnc.JavaApp.Service.FinancialService;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicalBillCreatorFactory {
    List<IMedicalBillCreator> medicalBillCreatorList;
    public IMedicalBillCreator getBillCreator(String type){
        return medicalBillCreatorList.stream()
                .filter(creator->creator.getType().equalsIgnoreCase(type))
                .findFirst().orElseThrow(()->new NullPointerException("wrong type"));
    }
}
