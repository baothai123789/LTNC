package com.ltnc.JavaApp.Service.ProfileService.Employee.CreateUserService;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Service.ProfileService.Employee.CreateUserService.IEmployeeCreateUserService;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public abstract class AbstractEmployeeCreateUserService<T extends Employee> implements IEmployeeCreateUserService {
    protected MongoRepository<T,String> modelRepository;
    protected Class<T> type;

    @Override
    public void createUser(Employee newemployee) {
        newemployee.setId(UUID.randomUUID().toString());
        modelRepository.save((T)newemployee);
    }

    @Override
    public String getType() {
        return this.type.getSimpleName();
    }
}
