package com.ltnc.JavaApp.Service;

import java.util.Optional;

import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.PharmacyManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public interface IInfomationService {
   Optional<Person> getData(String id);
}
