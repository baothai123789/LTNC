package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IRemoveScheduleService;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.ScheduleModel;
import lombok.Getter;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractRemoveScheduleService<T extends ScheduleModel> implements IRemoveScheduleService {
    protected Class<T> type;
    protected MongoTemplate mongoTemplate;
    @Override
    public void removeSchedule(String modelId, String scheduleId) throws NullPointerException{
        ScheduleModel model = mongoTemplate.findById(modelId,type);
        if(model==null){
            throw new NullPointerException("User not found");
        }
        int i =0;
        for(Schedule schedule:model.getSchedules()){
            if(schedule.getId().equals(scheduleId)){
                model.getSchedules().remove(i);
                break;
            }
            i++;
        }
        mongoTemplate.save(model);
    }
    public String getType(){
        return type.getSimpleName();
    }

}
