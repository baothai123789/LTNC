package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IGetScheduleService;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.ScheduleModel;

import lombok.Setter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public abstract class AbstractGetScheduleService<T extends ScheduleModel> implements IGetScheduleService {
    protected MongoRepository<T,String> repository;
    protected ScheduleRepository scheduleRepository;
    @Setter
    protected Class<T> type;
    @Override
    public List<Schedule> getSchedules(String modelId) throws NullPointerException {
        ScheduleModel patient = repository.findById(modelId).orElseThrow(NullPointerException::new);
        return patient.getSchedules().stream()
                .map(schedule -> scheduleRepository.findById(schedule.getId()).orElseThrow(NullPointerException::new))
                .toList();
    }

    @Override
    public List<Schedule> getSchedules(String modelId, LocalDate date) throws NullPointerException {
        MyApp.LOGGER.info(type);
        MyApp.LOGGER.info(modelId);
        ScheduleModel model = repository.findById(modelId).orElseThrow(NullPointerException::new);
        MyApp.LOGGER.info(model);
        MyApp.LOGGER.info(model.getSchedules().size());
        if(model.getSchedules().isEmpty()) return new ArrayList<>();
        List<Schedule> res = new ArrayList<>();
        for(Schedule schedule: model.getSchedules()){
            res.addAll(scheduleRepository.findbyDateandId(schedule.getId(),date));
        }
        return res;
    }
    public String getType(){
        return type.getSimpleName();
    }
}
