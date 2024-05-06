package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
import com.ltnc.JavaApp.Service.NotificationService.NotifyListener;
import com.ltnc.JavaApp.Service.NotificationService.NotifyObserver;
import com.ltnc.JavaApp.Service.NotificationService.ScheduleNotifyListener;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IAddScheduleService;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.ScheduleModel;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class AddScheduleService<T extends ScheduleModel> implements IAddScheduleService{

    @Resource
    private ScheduleRepository scheduleRepository;
    @Resource
    NotifyObserver notifyObserver;
    @Override
    public void addSchedule(ScheduleModel scheduleModel, Schedule newSchedule) throws NullPointerException{
        MyApp.LOGGER.info("add schedule");
        NotifyListener notifyListener = new ScheduleNotifyListener((Person) scheduleModel);
        notifyObserver.addListener("schedule",notifyListener);
        scheduleModel.addSchedule(newSchedule);
        scheduleRepository.save(newSchedule);
    }
}
