package com.ltnc.JavaApp.RequestModel.CreateUserRequestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginModel {
    private String username;
    private String password;
}
