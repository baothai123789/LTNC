package com.ltnc.JavaApp.Service.AccountService;

import com.ltnc.JavaApp.Model.UserAccount;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountValidatorService {
    @Autowired
    private UserAccountRepository userAccountRepository;
    boolean validateUsername(String username){
        UserAccount userAccount = userAccountRepository.findByUserName(username);
        MyApp.LOGGER.info(userAccount);
        return userAccount == null;
    }
    boolean validatePassword(String password){
        return !(password.length()<=8|password.length()>20);

    }
}
