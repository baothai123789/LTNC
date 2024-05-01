package com.ltnc.JavaApp.Service.AccountService;

import com.ltnc.JavaApp.Model.NotificationList;
import com.ltnc.JavaApp.Model.UserAccount;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.UserAccountRepository;
import com.ltnc.JavaApp.Service.AccountService.Exception.UnvalidAccountException;
import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegisterService {
    @Resource
    UserAccountRepository userAccountRepository;
    @Resource
    AccountValidatorService accountValidatorService;
    @Resource
    BCryptPasswordEncoder cryptPasswordEncoder;
    @Resource
    NotificationManage notificationManage;

    public void register(UserAccount userAccount)throws UnvalidAccountException {
        if(!accountValidatorService.validateUsername(userAccount.getUsername())){
            MyApp.LOGGER.info(userAccount.getUsername());
            throw new UnvalidAccountException("Username da ton tai");
        }
        if(!accountValidatorService.validatePassword(userAccount.getPassword())) {
            throw  new UnvalidAccountException("Mat khau khong hop le");
        }
        NotificationList notificationList = new NotificationList();
        notificationList.setId(UUID.randomUUID().toString());
        userAccount.setNotificationList(notificationList);
        notificationManage.createNotifications(userAccount.getNotificationList());
        userAccount.setPassword(cryptPasswordEncoder.encode(userAccount.getPassword()));
        this.userAccountRepository.save(userAccount);
    }
}
