package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.DoctorInfoScheduleDTO;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.DoctorInfoScheduleForPatientChoiceDTOMapper;
import com.ltnc.JavaApp.Service.ScheduleService.Exception.DoctorMajorNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.IntStream;

@Service
public class FindDoctorScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    DoctorInfoScheduleForPatientChoiceDTOMapper doctorInfoScheduleDTOMapper;
    private List<Integer> getDoctorScheduleList(List<Schedule> schedules) {

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

    public List<DoctorInfoScheduleDTO> getDoctorSchedule(LocalDate date, String major) throws DoctorMajorNotfoundException {
        List<Doctor> doctors = doctorRepository.findByMajor(major);
        if(doctors.isEmpty()){
            throw new DoctorMajorNotfoundException("Doctor major not found");
        }
        return doctors.stream()
                .map(doctor -> new AbstractMap.SimpleEntry<>(
                                doctor,getDoctorScheduleList(doctor.getSchedules().stream()
                                .filter(schedule -> schedule.getDate().equals(date)).toList())))
                .map(tuple->doctorInfoScheduleDTOMapper.map(tuple.getKey(),tuple.getValue()))
                .toList();
    }
}
