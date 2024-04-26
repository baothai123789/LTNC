package com.ltnc.JavaApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PharmacyManager")
public class PharmacyManager extends  FunctionalEmployee{
    @Id
    private String id;
    @DBRef
    private UserAccount userAccount;
    @Override
    public String getPart() {
        return "pharmacymanager";
    }

    @Override
    public String getRole() {
        return "pharmacymanager";
    }


}
