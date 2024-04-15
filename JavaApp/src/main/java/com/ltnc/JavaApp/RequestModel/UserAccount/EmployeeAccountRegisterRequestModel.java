package com.ltnc.JavaApp.RequestModel.UserAccount;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAccountRegisterRequestModel {
    private UserAccount userAccount;
    private Employee employee;
}
