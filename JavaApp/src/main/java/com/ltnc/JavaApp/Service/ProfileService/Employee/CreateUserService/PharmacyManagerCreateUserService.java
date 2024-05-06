package com.ltnc.JavaApp.Service.ProfileService.Employee.CreateUserService;

import com.ltnc.JavaApp.Model.PharmacyEquipmentManager;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.PharmacyManagerRepository;
import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyManagerCreateUserService extends AbstractEmployeeCreateUserService<PharmacyManager> {
    @Autowired
    public PharmacyManagerCreateUserService(PharmacyManagerRepository pharmacyManagerRepository){
        this.modelRepository = pharmacyManagerRepository;
        this.type= PharmacyManager.class;
    }
}
