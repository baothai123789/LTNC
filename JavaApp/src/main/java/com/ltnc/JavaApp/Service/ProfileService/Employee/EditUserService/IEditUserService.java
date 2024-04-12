package com.ltnc.JavaApp.Service.ProfileService.Employee.EditUserService;

import com.ltnc.JavaApp.Model.Employee;

public interface IEditUserService {
    public void editUser(String userId, Employee employee);
    public String getType();
}
