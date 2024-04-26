package com.ltnc.JavaApp.Service.ProfileService.Employee;

import com.ltnc.JavaApp.Model.Employee;

public interface IEmployeeProfileMangeService {
    public void createEmployeeProfile(Employee newEmployee,String type);
    public void editEmployeeProfile(String modelId,Employee employee,String type);
    public Employee getEmployeeProfile(String modelId,String type);
    public void UpdateUserProfile(Employee employee);
}
