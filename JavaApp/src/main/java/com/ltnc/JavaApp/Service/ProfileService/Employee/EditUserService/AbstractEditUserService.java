package com.ltnc.JavaApp.Service.ProfileService.Employee.EditUserService;

import com.ltnc.JavaApp.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract class AbstractEditUserService<T extends Employee> implements IEditUserService{
    protected MongoRepository<T,String> modelRepository;
    protected Class<T> type;
    @Override
    public void editUser(String userId, Employee employee) {
        employee.setId(userId);
        modelRepository.save((T)employee);
    }

    @Override
    public void updateUser(Employee employee) {
        this.modelRepository.save((T)employee);
    }

    @Override
    public String getType() {
        return type.getSimpleName();
    }

}
