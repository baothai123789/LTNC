package com.ltnc.JavaApp.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Repository.BenhnhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BenhnhanService {
    @Autowired
    private BenhnhanRepository repository;

    public void createnewBenhnhan(Doctor benhnhan){
        repository.save(benhnhan);
    }
}
