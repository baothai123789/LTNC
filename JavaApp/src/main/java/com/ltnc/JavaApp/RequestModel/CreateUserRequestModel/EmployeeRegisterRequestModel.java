package com.ltnc.JavaApp.RequestModel.CreateUserRequestModel;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRegisterRequestModel {
    Employee employee;
    UserAccount userAccount;
}
