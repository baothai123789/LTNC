package com.ltnc.JavaApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "UserAccount")
public class UserAccount {
    @Id
    private String id;
    private String username;
    private String password;
    private String role;
    @DBRef
    NotificationList notificationList;
}
