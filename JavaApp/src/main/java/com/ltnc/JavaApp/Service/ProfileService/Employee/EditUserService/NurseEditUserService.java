package com.ltnc.JavaApp.Service.ProfileService.Employee.EditUserService;

import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NurseEditUserService extends AbstractEditUserService<Nurse>{
    @Autowired
    public NurseEditUserService(NurseRepository nurseRepository){
        this.modelRepository = nurseRepository;
        this.type=Nurse.class;
    }
}
