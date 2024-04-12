package com.ltnc.JavaApp.Service.NotificationService;

import com.ltnc.JavaApp.Model.Notification;
import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Repository.NotificationRepository;
import com.ltnc.JavaApp.Service.ProfileService.Employee.IEmployeeProfileMangeService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.IPatientProfileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationGetter implements INotificationGetter{
    @Autowired
    private NotificationRepository notificationRepository;
    @Override
    public List<Notification> getNotifications(Person person) throws NullPointerException {
        return notificationRepository.findById(person.getNotifications().getId())
                .orElseThrow(NullPointerException::new).getNotifications();
    }
}
