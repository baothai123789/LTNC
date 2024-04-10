package com.ltnc.JavaApp.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document(collection = "FinancialEmployee")
public class FinancialEmployee extends FunctionalEmployee {
    @Id
    private String id;
    private int salary;

    @DBRef
    private List<SchedulePay> schedulePays;

    public FinancialEmployee() {
        this.part = "Financial";
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getRole(){
        return "FinancialEmployee";
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
