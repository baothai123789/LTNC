package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.NotificationList;
import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.UserAccount;
import com.ltnc.JavaApp.Service.AccountService.IUserManageService;
import com.ltnc.JavaApp.Service.AccountService.UserAccountService;
import jakarta.annotation.Resource;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationManage implements INotificationManage{
    @Resource
    IUserManageService userAccountService;
    @Resource
    IUpdateNotification updateNotification;
    @Resource
    INotificationGetter notificationGetter;
    @Resource
    INotificationSender notificationSender;
    @Resource
    ICreateNotificationList createNotificationList;
    @Override
    public void sendNotification(Notification notification,Person userid) {
        this.notificationSender.sendNotification(notification,userid);
    }

    @Override
    public List<Notification> getNotifications(String userid) {
        return this.notificationGetter.getNotifications(userid);
    }

    @Override
    public void createNotifications(NotificationList notifications) {
        this.createNotificationList.createNotificationList(notifications);
    }

    @Override
    public void setRead(String username) {
        UserAccount userAccount = userAccountService.getUserAccount(username);
        if (userAccount==null) throw new RuntimeException("username not found");
        userAccount.getNotificationList().getNotifications().forEach(
                notification -> notification.setHasRead(true)
        );
        updateNotification.updateNotifications(userAccount.getNotificationList());
    }
}
