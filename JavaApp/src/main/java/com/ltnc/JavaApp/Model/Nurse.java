package com.ltnc.JavaApp.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Nurse")
public class Nurse extends Employee {
    @Id
    private String id;

    public Nurse() {
        this.role = "nurse";
    }
    @Override
    public void setRole(String role){
        this.role = "nurse";
    }
    public String getRole(){
        return "nurse";
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
