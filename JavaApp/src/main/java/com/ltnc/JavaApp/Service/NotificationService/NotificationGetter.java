package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.NotificationList;
import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.UserAccount;
import com.ltnc.JavaApp.Repository.NotificationRepository;
import com.ltnc.JavaApp.Repository.UserAccountRepository;
import com.ltnc.JavaApp.Service.ProfileService.Employee.IEmployeeProfileMangeService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.IPatientProfileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationGetter implements INotificationGetter{
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Override
    public List<Notification> getNotifications(String username) throws NullPointerException {
        UserAccount userAccount=userAccountRepository.findByUserName(username);
        return userAccount.getNotificationList().getNotifications();
    }
}
