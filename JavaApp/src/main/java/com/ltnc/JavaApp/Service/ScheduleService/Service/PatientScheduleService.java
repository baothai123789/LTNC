package com.ltnc.JavaApp.Service.ScheduleService.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.PatientScheduleDTO;

import com.ltnc.JavaApp.Service.ScheduleService.Interface.IPatientScheduleService;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IScheduleManageService;
import org.springframework.beans.factory.annotation.Autowired;

import com.ltnc.JavaApp.Model.Schedule;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
public class PatientScheduleService implements IPatientScheduleService {
    @Autowired
    ScheduleMangeService scheduleMangeService;



    private List<Integer> getDoctorSchedule(List<Schedule> schedules) {

            Boolean[] time=new Boolean[24];
            Arrays.fill(time,true);
            for(Schedule schedule:schedules) {
                int startTime = schedule.getStartTime()-1;
                int endTime = schedule.getEndTime();
                while (startTime<endTime) {
                    time[startTime] = false;
                    startTime++;
                }
            }
            return IntStream.range(8,17).boxed().filter(i->time[i-1]&&(i<11|i>13)).toList();
    }

    @Override
    public PatientScheduleDTO patientSchedule(LocalDate date, String doctorId,String patientId) throws NullPointerException {
        List<Schedule> doctorSchedule = scheduleMangeService.getSchedulesbyDate(doctorId,date,"doctor");
        MyApp.LOGGER.info(doctorSchedule);
        List<Integer> doctorTime = getDoctorSchedule(doctorSchedule);
        MyApp.LOGGER.info(doctorTime);
        if(doctorTime.isEmpty()) return null;
        Schedule newschedule = new Schedule(UUID.randomUUID().toString(),date,doctorTime.get(0),doctorTime.get(0)+1,"kham benh",patientId,doctorId);
        scheduleMangeService.addSchedule(newschedule,doctorId,"doctor");
        scheduleMangeService.addSchedule(newschedule,patientId,"patient");
        return new PatientScheduleDTO(newschedule.getId(), newschedule.getStartTime(),date,doctorId);
    }
}

