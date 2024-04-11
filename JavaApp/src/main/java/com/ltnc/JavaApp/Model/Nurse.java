package com.ltnc.JavaApp.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Nurse")
public class Nurse extends Employee {
    @Id
    private String Id;
    private int salary;
    public Nurse() {
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public String getRole() {
        return "";
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int getSalary() {
        return this.salary;
    }
}
