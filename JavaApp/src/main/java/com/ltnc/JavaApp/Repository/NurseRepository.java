package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.Nurse;
import org.springframework.data.mongodb.repository.MongoRepository;
<<<<<<< HEAD

import org.springframework.stereotype.Component;
=======
>>>>>>> c7f46f9da7b8b3b0748f1931574a012568911c0f
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends MongoRepository<Nurse,String> {
}
