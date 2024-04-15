package com.ltnc.JavaApp.RequestModel.UserAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestModel {
    private String username;
    private String password;
}
