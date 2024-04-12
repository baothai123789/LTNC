package com.ltnc.JavaApp.Service.ProfileService.Employee.CreateUserService;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.NotificationList;
import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import com.ltnc.JavaApp.Service.ProfileService.Employee.CreateUserService.IEmployeeCreateUserService;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public abstract class AbstractEmployeeCreateUserService<T extends Employee> implements IEmployeeCreateUserService {
    protected MongoRepository<T,String> modelRepository;
    protected Class<T> type;
    protected NotificationManage notificationManage;
    @Override
    public void createUser(Employee newemployee) {
        NotificationList notificationList = new NotificationList();
        notificationList.setId(UUID.randomUUID().toString());
        newemployee.setId(UUID.randomUUID().toString());
        newemployee.setNotifications(notificationList);
        modelRepository.save((T)newemployee);
        notificationManage.createNotifications(notificationList);

    }

    @Override
    public String getType() {
        return this.type.getSimpleName();
    }
}
