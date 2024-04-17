package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IAddScheduleService;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.ScheduleModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;


public abstract class AbstractAddScheduleService<T extends ScheduleModel> implements IAddScheduleService{
    protected Class<T> type;
    protected MongoRepository<T,String> repository;
    protected ScheduleRepository scheduleRepository;
    @Override
    public void addSchedule(String modelId, Schedule newSchedule) throws NullPointerException{
        T model = repository.findById(modelId).orElseThrow(NullPointerException::new);
        model.addSchedule(newSchedule);
        repository.save(model);
        scheduleRepository.save(newSchedule);

    }
    @Override
    public String getType(){
        return this.type.getSimpleName();
    }
}
