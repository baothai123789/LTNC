package com.ltnc.JavaApp.Service.PharmacyManager;

import com.ltnc.JavaApp.Model.Medicine;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.MedicineRepository;
import com.ltnc.JavaApp.Repository.PharmacyManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class RemoveMedicineService implements IRemoveMedicineService{
    @Autowired
    MongoOperations mongoOperations;
    @Autowired
    MedicineRepository medicineRepository;

    @Override
    public void removeMedicinesExpire(LocalDate expireDate) throws NullPointerException {
        Query query = new Query();
        query.addCriteria(Criteria.where("expireDay").gte(expireDate));
        mongoOperations.findAndRemove(query,Medicine.class);
    }
    @Override
    public void removeFromMedicalBill(List<Map<String,Object>> presciption){
        for(Map<String,Object> medicine:presciption){
            int target = (int)medicine.get("amount");
            List<Medicine> medicine_db=medicineRepository.findByName((String) medicine.get("name"));
            for(int i =0;i<medicine_db.size();++i){
                int amount = medicine_db.get(i).getAmount();
                if(amount<=target){
                    medicineRepository.delete(medicine_db.get(i));
                    target-=amount;
                }
                else{
                    medicine_db.get(i).setAmount(amount-target);
                    medicineRepository.save(medicine_db.get(i));
                }
                if(target==0){
                    break;
                }
            }
        }

    }
}
