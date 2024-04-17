package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Schedule;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
public class FindDoctorScheduleService {
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
    public Schedule getSchedules(Doctor doctor, LocalDate date) throws NullPointerException {
        List<Schedule> doctorScheduleByDate= doctor.getSchedules().stream().filter(schedule -> schedule.getDate().equals(date)).toList();
        List<Integer> doctorTime = getDoctorSchedule(doctorScheduleByDate);
        if(doctorTime.isEmpty()) throw new NullPointerException("schedule doctor not found");
        return new Schedule(
                UUID.randomUUID().toString(),
                date,
                doctorTime.get(0),
                doctorTime.get(0)+1,
                "Lịch tái khám"
        );
    }
}
