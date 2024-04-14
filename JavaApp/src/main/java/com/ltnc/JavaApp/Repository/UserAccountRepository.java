package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.UserAccount;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.scheduling.support.SimpleTriggerContext;

public interface UserAccountRepository extends MongoRepository<UserAccount,String> {
    @Query("{'userName': ?0}")
    public UserAccount findByUserName(String username);
}
