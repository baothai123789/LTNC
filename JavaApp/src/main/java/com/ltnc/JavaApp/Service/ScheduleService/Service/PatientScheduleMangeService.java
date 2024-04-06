package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IScheduleManageService;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.ScheduleModel;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PatientScheduleMangeService implements IScheduleManageService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public void addSchedule(Schedule newschedule, String modelId)throws NullPointerException {
        newschedule.setId(UUID.randomUUID().toString());
        Patient patient=patientRepository.findById(modelId).orElseThrow(NullPointerException::new);
        patient.addSchedule(newschedule);
        patientRepository.save(patient);
        scheduleRepository.save(newschedule);
    }

    @Override
    public void removeSchedule(String scheduleId, String modelId) {
        Patient patient = patientRepository.findById(modelId).get();
        scheduleRepository.deleteById(scheduleId);
        patient.removeSchedule(scheduleId);
    }

    @Override
    public List<Schedule> getSchedules(String modelId) {
        return patientRepository.findById(modelId).get().getSchedules();

    }

    @Override
    public List<Schedule> getSchedulesbyDate(String modelId, LocalDate date) {
        List<Schedule> res = new ArrayList<>();
        Patient patient = patientRepository.findById(modelId).get();
        for(Schedule schedule:patient.getSchedules()){
            res.addAll(scheduleRepository.findbyDateandId(date,schedule.getId()));
        }
        return res;
    }
}
