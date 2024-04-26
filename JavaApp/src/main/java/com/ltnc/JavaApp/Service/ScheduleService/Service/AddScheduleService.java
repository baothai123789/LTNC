package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IAddScheduleService;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.ScheduleModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;


@Service
public class AddScheduleService<T extends ScheduleModel> implements IAddScheduleService{
    protected ScheduleRepository scheduleRepository;
    @Override
    public void addSchedule(ScheduleModel scheduleModel, Schedule newSchedule) throws NullPointerException{
        scheduleModel.addSchedule(newSchedule);
        scheduleRepository.save(newSchedule);
    }
}
