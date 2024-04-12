package com.ltnc.JavaApp.Service.ProfileService.Employee;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Service.ProfileService.Employee.CreateUserService.IEmployeeCreateUserService;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EditUserService.IEditUserService;
import com.ltnc.JavaApp.Service.ProfileService.Employee.GetProfileService.IGetProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProfileManageService implements IEmployeeProfileMangeService {
    @Autowired
    List<IGetProfileService> getProfileServices;
    @Autowired
    List<IEmployeeCreateUserService> employeeCreateUserServices;
    @Autowired
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
        IEditUserService service = editUserServices.stream().filter(
                editService->editService.getType().equalsIgnoreCase(type)
        ).findFirst().orElseThrow(NullPointerException::new);
        service.editUser(modelId,employee);
    }

    @Override
    public Employee getEmployeeProfile(String modelId, String type) {
        return getProfileServices.stream().filter(
                getService->getService.getType().equalsIgnoreCase(type)
        ).findFirst().orElseThrow(NullPointerException::new).getUserProfile(modelId);
    }
}
