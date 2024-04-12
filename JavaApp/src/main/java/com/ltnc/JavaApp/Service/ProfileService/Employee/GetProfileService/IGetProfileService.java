package com.ltnc.JavaApp.Service.ProfileService.Employee.GetProfileService;

import com.ltnc.JavaApp.Model.Employee;

public interface IGetProfileService {
    public Employee getUserProfile(String id);
    public String getType();
}
