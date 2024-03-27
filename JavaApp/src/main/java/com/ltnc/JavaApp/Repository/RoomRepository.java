package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;


@Component
public interface RoomRepository extends MongoRepository<Room,String> {
}
