package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Service.NotificationService.INotificationGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/notify")
public class NotificationController {
    @Autowired
    INotificationGetter notificationGetter;
    @PreAuthorize("hasAnyAuthority('patient','doctor','nurse','financialemployee','pharmacymanager')")
    @GetMapping("/getnotify/{username}")
    public ResponseEntity<List<Notification>> getNotification(@PathVariable("username") String username){
        try {
            List<Notification> res = notificationGetter.getNotifications(username);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        catch (NullPointerException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
