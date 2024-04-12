package com.ltnc.JavaApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document("Salary")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryOfEmployee {
    @Id
    private Map<String,Integer> salaries = new HashMap<>();


    public void addEmployeeSalary(String id, int salary) {
        this.salaries.put(id, salary);
    }

    public int getEmployeeSalary(String Id) {
        return this.salaries.getOrDefault(Id, 0);
    }
}
