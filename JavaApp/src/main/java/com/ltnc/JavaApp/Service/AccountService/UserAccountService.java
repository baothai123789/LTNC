package com.ltnc.JavaApp.Service.AccountService;

import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.UserAccount;
import com.ltnc.JavaApp.MyApp;

import com.ltnc.JavaApp.Repository.UserAccountRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.util.Pair;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.util.*;

@Service
public class UserAccountService implements UserDetailsService,IUserManageService {
    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findByUserName(username);
        MyApp.LOGGER.info(userAccount);
        if (userAccount==null) throw new UsernameNotFoundException("not found user");
        return new CustomUserDetails(userAccount);
    }
    public Collection<? extends GrantedAuthority> mapRolesToAuthorities(String role){
        List<SimpleGrantedAuthority> res = new ArrayList<>();
        res.add(new SimpleGrantedAuthority(role));
        return res;
    }

    @Override
    public Map<String,String> getUserId(String username) {
        UserAccount userAccount = userAccountRepository.findByUserName(username);
        String role = userAccount.getRole();
        String classname = "com.ltnc.JavaApp.Model."+role.substring(0,1).toUpperCase()+role.substring(1);
        Class<? extends Person> type;
        try {
            type = Class.forName(classname).asSubclass(Person.class);
            Query query = new Query();
            query.addCriteria(Criteria.where("userAccount.$id").is(userAccount.getId()));
            Person person =mongoTemplate.findOne(query,type);
            if(person==null) throw  new NullPointerException("user not found");
            return new HashMap<>(Map.of("role",userAccount.getRole(),"userId",person.getId()));
        }
        catch (ClassNotFoundException e){
            MyApp.LOGGER.info(e);
            throw new ClassCastException(e.getMessage());
        }
        catch (NullPointerException e){
            MyApp.LOGGER.info(e);
            throw new NullPointerException(e.getMessage());
        }
    }
}
