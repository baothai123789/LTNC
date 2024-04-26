package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ScheduleMedicalDetailService {
    public List<Schedule> createMedicalSchedule(Doctor doctor, Patient patient, List<MedicalSchedule> medicalScheduleList){
       List<Schedule> res = new ArrayList<>();
        for(MedicalSchedule medicalSchedule:medicalScheduleList){
           Schedule schedule = new Schedule();
           schedule.setId(UUID.randomUUID().toString());
           schedule.setDetail("Tái khám");
           schedule.setDate(medicalSchedule.getTime().toLocalDate());
           schedule.setStartTime(medicalSchedule.getTime().getHour());
           schedule.setEndTime(medicalSchedule.getTime().getHour()+1);
           doctor.addSchedule(schedule);
           patient.addSchedule(schedule);
           res.add(schedule);
       }
        return res;
    }
}
