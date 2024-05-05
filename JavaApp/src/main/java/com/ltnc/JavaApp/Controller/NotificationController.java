package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Service.NotificationService.INotificationGetter;
import com.ltnc.JavaApp.Service.NotificationService.INotificationManage;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/notify")
public class NotificationController {
    @Resource
    INotificationGetter notificationGetter;
    @Resource
    INotificationManage notificationManage;
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
    @PreAuthorize("hasAnyAuthority('patient','doctor','nurse','financialemployee','pharmacymanager')")
    @PutMapping("/setread/{username}")
    public ResponseEntity<Map<String,String>> setNotifiRead(@PathVariable("username") String username){
        try {
            notificationManage.setRead(username);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(new HashMap<>(Map.of("message",e.getMessage())),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.ACCEPTED);
    }
}
