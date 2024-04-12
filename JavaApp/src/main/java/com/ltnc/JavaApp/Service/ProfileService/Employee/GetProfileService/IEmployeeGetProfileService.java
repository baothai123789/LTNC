package com.ltnc.JavaApp.Service.ProfileService.Employee.GetProfileService;

import com.ltnc.JavaApp.Model.Employee;

public interface IEmployeeGetProfileService {
    public Employee getUserProfile(String id);
    public String getType();
}
