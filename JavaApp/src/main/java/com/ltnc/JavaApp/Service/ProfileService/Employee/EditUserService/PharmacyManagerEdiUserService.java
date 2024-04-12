package com.ltnc.JavaApp.Service.ProfileService.Employee.EditUserService;

import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.PharmacyManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyManagerEdiUserService extends AbstractEditUserService<PharmacyManager>{
    @Autowired
    public PharmacyManagerEdiUserService(PharmacyManagerRepository pharmacyManagerRepository){
        this.modelRepository= pharmacyManagerRepository;
        this.type=PharmacyManager.class;
    }
}
