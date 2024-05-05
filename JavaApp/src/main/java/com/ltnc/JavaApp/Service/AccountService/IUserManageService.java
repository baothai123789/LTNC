package com.ltnc.JavaApp.Service.AccountService;

import com.ltnc.JavaApp.Model.UserAccount;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

public interface IUserManageService {
    public Map<String,String> getUserId(String username);
    public UserAccount getUserAccount(String username);

}
