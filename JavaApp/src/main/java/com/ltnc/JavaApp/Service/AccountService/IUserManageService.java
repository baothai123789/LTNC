package com.ltnc.JavaApp.Service.AccountService;

import org.springframework.data.util.Pair;

import java.util.Map;

public interface IUserManageService {
    public Map<String,String> getUserId(String username);

}
