package com.ltnc.JavaApp.Service.PharmacyManager;

import com.ltnc.JavaApp.Model.Medicine;
import com.ltnc.JavaApp.Repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetMedicinesService implements IGetMedicines{
    @Autowired
    MedicineRepository medicineRepository;

    @Override
    public List<Medicine> getMedicines() {
        return medicineRepository.findAll();
    }
    @Override
    public Integer getMedicinePrice(List<Map<String,Object>> presciption){
        int i = 0;
        int total=0;
        for(Map<String,Object> medicine:presciption){
            List<Medicine> medicines = medicineRepository.findByName((String)medicine.get("name"));
            if(medicines.isEmpty()){
                presciption.get(i).put("price",-1);
                presciption.get(i).put("inInventory",false);
            }
            else {
                int res = medicines.get(0).getPricePerUnit();
                presciption.get(i).put("price",res);
                presciption.get(i).put("inInventory",false);
                total+=res;
            }
            i++;
        }
        return total;
    }
}
