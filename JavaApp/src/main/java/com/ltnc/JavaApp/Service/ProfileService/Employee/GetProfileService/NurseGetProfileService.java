package com.ltnc.JavaApp.Service.ProfileService.Employee.GetProfileService;

import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NurseGetProfileService extends AbstractGetProfileService<Nurse> {
    @Autowired
    public NurseGetProfileService(NurseRepository nurseRepository){
        this.modelRepository = nurseRepository;
        this.type=Nurse.class;
    }
}
