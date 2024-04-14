package com.ltnc.JavaApp.Service.AccountService;

import com.ltnc.JavaApp.Model.UserAccount;
import com.ltnc.JavaApp.Repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserAccountService implements UserDetailsService {
    @Autowired
    UserAccountRepository userAccountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findByUserName(username);
        if (userAccount==null) return null;
        return new CustomUserDetails(userAccount);
    }
    public Collection<? extends GrantedAuthority> mapRolesToAuthorities(String role){
        List<SimpleGrantedAuthority> res = new ArrayList<>();
        res.add(new SimpleGrantedAuthority(role));
        return res;
    }
}
