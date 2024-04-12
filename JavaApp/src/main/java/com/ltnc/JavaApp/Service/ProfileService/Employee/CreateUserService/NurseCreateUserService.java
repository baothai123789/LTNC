package com.ltnc.JavaApp.Service.ProfileService.Employee.CreateUserService;

import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Repository.NurseRepository;

import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import com.ltnc.JavaApp.Service.ProfileService.Employee.CreateUserService.AbstractEmployeeCreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NurseCreateUserService extends AbstractEmployeeCreateUserService<Nurse> {
    @Autowired
    public NurseCreateUserService(NurseRepository nurseRepository, NotificationManage notificationManage){
        this.modelRepository=nurseRepository;
        this.type=Nurse.class;
        this.notificationManage=notificationManage;
    }
}
