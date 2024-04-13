package com.ltnc.JavaApp.RequestModel.Notification;

import com.ltnc.JavaApp.Model.Notification;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequestModel {
    private UserNotifyinfo userNotifyinfo;
    private Notification notification;
}
