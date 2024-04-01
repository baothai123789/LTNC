package com.ltnc.JavaApp.Service;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ltnc.JavaApp.Model.Person;

@Component
@Service
public interface IInfomationService {
   Optional<Person> getData(String id); 
}
