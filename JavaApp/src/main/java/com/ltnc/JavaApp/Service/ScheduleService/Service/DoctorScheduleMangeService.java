package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IScheduleManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DoctorScheduleMangeService implements IScheduleManageService{
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Override
    public void addSchedule(Schedule newschedule, String modelId)throws NullPointerException {
        newschedule.setId(UUID.randomUUID().toString());
        Doctor patient=doctorRepository.findById(modelId).orElseThrow(NullPointerException::new);
        patient.addSchedule(newschedule);
        doctorRepository.save(patient);
        scheduleRepository.save(newschedule);
    }

    @Override
    public void removeSchedule(String scheduleId, String modelId) {
        Doctor patient = doctorRepository.findById(modelId).get();
        scheduleRepository.deleteById(scheduleId);
        patient.removeSchedule(scheduleId);
    }

    @Override
    public List<Schedule> getSchedules(String modelId) {
        return doctorRepository.findById(modelId).get().getSchedules();

    }

    @Override
    public List<Schedule> getSchedulesbyDate(String modelId, LocalDate date) {
        List<Schedule> res = new ArrayList<>();
        Doctor patient = doctorRepository.findById(modelId).get();
        for(Schedule schedule:patient.getSchedules()){
            res.addAll(scheduleRepository.findbyDateandId(date,schedule.getId()));
        }
        return res;
    }
}
