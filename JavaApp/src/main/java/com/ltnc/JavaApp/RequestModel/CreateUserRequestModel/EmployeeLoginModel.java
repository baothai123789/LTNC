package com.ltnc.JavaApp.RequestModel.CreateUserRequestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeLoginModel {
    private String username;
    private String password;
    private String role;
}