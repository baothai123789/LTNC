package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.RoomManager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoomManagerRepository extends MongoRepository<RoomManager,String> {
}
