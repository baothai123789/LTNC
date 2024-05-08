package com.ltnc.JavaApp.Service.ProfileService.Employee;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Service.ProfileService.Employee.CreateUserService.IEmployeeCreateUserService;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EditUserService.IEditUserService;
import com.ltnc.JavaApp.Service.ProfileService.Employee.GetProfileService.IEmployeeGetProfileService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProfileManageService implements IEmployeeProfileMangeService {
    @Resource
    List<IEmployeeGetProfileService> getProfileServices;
    @Resource
    List<IEmployeeCreateUserService> employeeCreateUserServices;
    @Resource
    List<IEditUserService> editUserServices;


    @Override
    public void createEmployeeProfile(Employee newEmployee,String type) throws NullPointerException {
        IEmployeeCreateUserService service = employeeCreateUserServices.stream().filter(
                createService->createService.getType().equalsIgnoreCase(type)
        ).findFirst().orElseThrow(NullPointerException::new);
        service.createUser(newEmployee);
    }

    @Override
    public void editEmployeeProfile(String modelId, Employee employee, String type) {
        employee.setId(modelId);
        IEditUserService service = editUserServices.stream().filter(
                createService->createService.getType().equalsIgnoreCase(type)
        ).findFirst().orElseThrow(NullPointerException::new);
        service.editUser(modelId,employee);
    }

    @Override
    public Employee getEmployeeProfile(String modelId, String type) {
        return getProfileServices.stream().filter(
                getService->getService.getType().equalsIgnoreCase(type)
        ).findFirst().orElseThrow(NullPointerException::new).getUserProfile(modelId);
    }

    @Override
    public void UpdateUserProfile(Employee employee) {
        String type = employee.getRole().equalsIgnoreCase("functionemployee")?employee.getPart():employee.getRole();
        IEditUserService editUserService = editUserServices.stream().filter(service->service.getType().equalsIgnoreCase(type))
                .findFirst().orElseThrow(()->new NullPointerException("Service not found"));
        editUserService.updateUser(employee);
    }

}
