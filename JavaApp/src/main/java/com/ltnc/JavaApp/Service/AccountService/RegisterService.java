package com.ltnc.JavaApp.Service.AccountService;

import com.ltnc.JavaApp.Model.UserAccount;
import com.ltnc.JavaApp.Repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    UserAccountRepository userAccountRepository;

    public void register(UserAccount userAccount){
        this.userAccountRepository.save(userAccount);
    }
}
