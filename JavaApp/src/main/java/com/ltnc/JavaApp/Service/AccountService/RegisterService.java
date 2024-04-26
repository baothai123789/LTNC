package com.ltnc.JavaApp.Service.AccountService;

import com.ltnc.JavaApp.Model.UserAccount;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.UserAccountRepository;
import com.ltnc.JavaApp.Service.AccountService.Exception.UnvalidAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    AccountValidatorService accountValidatorService;
    @Autowired
    BCryptPasswordEncoder cryptPasswordEncoder;

    public void register(UserAccount userAccount)throws UnvalidAccountException {
        if(!accountValidatorService.validateUsername(userAccount.getUsername())){
            MyApp.LOGGER.info(userAccount.getUsername());
            throw new UnvalidAccountException("Username da ton tai");
        }
        if(!accountValidatorService.validatePassword(userAccount.getPassword())) {
            throw  new UnvalidAccountException("Mat khau khong hop le");
        }
        userAccount.setPassword(cryptPasswordEncoder.encode(userAccount.getPassword()));
        this.userAccountRepository.save(userAccount);
    }
}
