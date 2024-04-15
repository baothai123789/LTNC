package com.ltnc.JavaApp.Service.AccountService;

import com.ltnc.JavaApp.Model.UserAccount;
import com.ltnc.JavaApp.Repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements IRegisterService {
    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public void register(UserAccount userAccount) {
        userAccountRepository.save(userAccount);
    }
}
