package com.ltnc.JavaApp.Service.ProfileService.Employee.EditUserService;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.PharmacyEquipmentManager;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.PharmacyManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyManagerEdiUserService extends AbstractEditUserService<PharmacyManager>{
    @Autowired
    public PharmacyManagerEdiUserService(PharmacyManagerRepository pharmacyManagerRepository){
        this.modelRepository= pharmacyManagerRepository;
        this.type= PharmacyManager.class;
    }

    @Override
    public void editUser(String userId, Employee employee) {
        PharmacyManager pharmacyManager_db=((PharmacyManagerRepository) this.modelRepository).findById(userId)
                .orElseThrow(()->new NullPointerException("user not found"));
        PharmacyManager pharmacyManager = (PharmacyManager) employee;
        pharmacyManager.setUserAccount(pharmacyManager_db.getUserAccount());
        ((PharmacyManagerRepository)this.modelRepository).save(pharmacyManager);
    }
}
