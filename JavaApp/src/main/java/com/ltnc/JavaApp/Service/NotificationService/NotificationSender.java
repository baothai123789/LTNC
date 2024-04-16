package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.*;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Setter
@Service
public class NotificationSender<T extends Person> implements INotificationSender<T>{

    private MongoRepository<T,String> repository;

    @Override
    public void sendNotification(Notification notification, String userId) {
        Person person = this.repository.findById(userId).orElseThrow(()->new NullPointerException("user not found"));
        
    }
}
