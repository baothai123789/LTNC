package com.ltnc.JavaApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Document(collection = "Nurse")
public class Nurse extends Employee {
    @Id
    private String id;

    public Nurse() {
        this.role = "nurse";
    }
    @Override
    public String getRole(){
        return "nurse";
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    public String getId(){return id;}
}
