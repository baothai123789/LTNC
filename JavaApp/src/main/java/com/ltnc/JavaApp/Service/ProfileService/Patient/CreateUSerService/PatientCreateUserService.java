package com.ltnc.JavaApp.Service.ProfileService.Patient.CreateUSerService;

import com.ltnc.JavaApp.Model.NotificationList;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.PatientRepository;


import java.util.UUID;

import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientCreateUserService implements IPatientCreateUserService {
    @Autowired
    private PatientRepository repository;

    @Autowired
    private NotificationManage notificationManage;
    public void createUser(Patient newpatient){
        NotificationList notificationList = new NotificationList();
        notificationList.setId(UUID.randomUUID().toString());
        newpatient.setId(UUID.randomUUID().toString());
        newpatient.setNotifications(notificationList);
        repository.save(newpatient);
        notificationManage.createNotifications(notificationList);
    }

}
