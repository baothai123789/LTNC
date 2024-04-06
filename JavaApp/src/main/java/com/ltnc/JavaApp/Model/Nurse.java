package com.ltnc.JavaApp.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Document(collection = "Nurse")
public class Nurse extends Employee {
    @Id
    private String id;

    public Nurse() {}
    @Override
    public String getRole(){
        return "nurse";
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
}
