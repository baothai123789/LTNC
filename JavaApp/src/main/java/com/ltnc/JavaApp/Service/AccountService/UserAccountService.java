package com.ltnc.JavaApp.Service.AccountService;

import com.ltnc.JavaApp.Model.*;
import com.ltnc.JavaApp.MyApp;

import com.ltnc.JavaApp.Repository.UserAccountRepository;

import jakarta.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class UserAccountService implements UserDetailsService,IUserManageService {
    @Resource
    UserAccountRepository userAccountRepository;
    @Resource
    MongoTemplate mongoTemplate;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findByUserName(username);
        MyApp.LOGGER.info(userAccount);
        if (userAccount==null) throw new UsernameNotFoundException("not found user");
        return new CustomUserDetails(userAccount);
    }


    @Override
    public Map<String,String> getUserId(String username) {
        UserAccount userAccount = userAccountRepository.findByUserName(username);
        String role = userAccount.getRole();
        Class<? extends Person> type;
        if(role.equalsIgnoreCase("patient")){
            type = Patient.class;
        }
        else if(role.equalsIgnoreCase("doctor")){
            type = Doctor.class;
        }
        else if(role.equalsIgnoreCase("nurse")){
            type = Nurse.class;
        }
        else if(role.equalsIgnoreCase("financialemployee")){
            type = FinancialEmployee.class;
        }
        else{
            type = PharmacyManager.class;
        }
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("userAccount.$id").is(userAccount.getId()));
            Person person =mongoTemplate.findOne(query,type);
            if(person==null) throw  new NullPointerException("user not found");
            return new HashMap<>(Map.of("role",userAccount.getRole(),"userId",person.getId()));
        }
        catch (NullPointerException e){
            MyApp.LOGGER.info(e);
            throw new NullPointerException(e.getMessage());
        }
    }
}
