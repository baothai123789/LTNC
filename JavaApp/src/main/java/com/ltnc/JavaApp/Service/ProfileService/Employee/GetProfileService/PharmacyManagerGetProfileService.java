package com.ltnc.JavaApp.Service.ProfileService.Employee.GetProfileService;

import com.ltnc.JavaApp.Model.PharmacyEquipmentManager;
import com.ltnc.JavaApp.Repository.PharmacyManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyManagerGetProfileService extends AbstractGetProfileService<PharmacyEquipmentManager>{
    @Autowired
    public PharmacyManagerGetProfileService(PharmacyManagerRepository pharmacyManagerRepository){
        this.modelRepository = pharmacyManagerRepository;
        this.type = PharmacyEquipmentManager.class;
    }
}
