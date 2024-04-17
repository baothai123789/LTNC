package com.ltnc.JavaApp.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.User;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PharmacyManagers")
public class PharmacyManager extends FunctionalEmployee{
    @Id
    private String id;
    @DBRef
    private UserAccount userAccount;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getPart() {
        return "pharmacymanager";
    }

    @Override
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
