package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.RequestModel.Notification.NotificationRequestModel;
import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.PatientProfileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    NotificationManage notificationManage;

    @Autowired
    EmployeeProfileManageService employeeProfileManageService;

    @Autowired
    PatientProfileManageService patientProfileManageService;
    @PreAuthorize("hasAnyAuthority('doctor','nurse','financialemployee')")

    @PostMapping("/sendnotification/")
    public ResponseEntity<Map<String,String>> sendNotification(@RequestBody NotificationRequestModel notificationRequestModel)
    {
        Notification notification = notificationRequestModel.getNotification();
        String userId = notificationRequestModel.getUserNotifyinfo().getId();
        String role = notificationRequestModel.getUserNotifyinfo().getRole();
        Person person;
        if(role.equalsIgnoreCase("patient")){
            person = patientProfileManageService.getProfile(userId);
        }
        else{
            person = employeeProfileManageService.getEmployeeProfile(userId,role);
        }
        notificationManage.sendNotification(notification,person.getNotifications());
        String message = "Success to send notification to user with id:"+person.getId();
        return new ResponseEntity<>(new HashMap<>(Map.of("message",message)), HttpStatus.CREATED);
    }
    @PreAuthorize("hasAnyAuthority('doctor','nurse','financialemployee','pharmacymanager')")
    @GetMapping("getnotification/{role}/{userId}")
    public ResponseEntity<List<Notification>> getUserNotification(@PathVariable("userId") String userId,@PathVariable("role") String role){
        Person person;
        try {
            if (role.equalsIgnoreCase("patient")) {
                person = patientProfileManageService.getProfile(userId);
            } else {
                person = employeeProfileManageService.getEmployeeProfile(userId, role);
            }
        }
        catch (NullPointerException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        List<Notification> res = notificationManage.getNotifications(person);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
