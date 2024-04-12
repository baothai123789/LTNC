package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.NotificationList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<NotificationList, String> {
}
