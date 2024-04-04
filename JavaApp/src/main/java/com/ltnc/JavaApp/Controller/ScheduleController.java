package com.ltnc.JavaApp.Controller;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Service.FindDoctorbyMajor;
import com.ltnc.JavaApp.Service.ScheduleService;

@RestController
@RequestMapping("/schedule")
@Component
public class ScheduleController{
    @Autowired
    ScheduleService service;

    @Autowired
    FindDoctorbyMajor findDoctorbyMajor;

    @GetMapping("/doctors/{major}")
    ResponseEntity<List<Doctor>> getDoctorsbyMajor(@PathVariable("major") String major){
        List<Doctor> doctors = findDoctorbyMajor.finDoctors(major);
        return new ResponseEntity<>(doctors,doctors.isEmpty()?HttpStatus.NOT_FOUND:HttpStatus.OK);
    }

    @GetMapping("/getschedule/{doctor}/{date}")
    ResponseEntity<List<Integer>>getSchedule(@PathVariable("doctor") String doctorid,@PathVariable("date") String date){
        List<Schedule> schedules=service.getDoctorSchedule(doctorid,LocalDate.parse(date));
        List<Boolean> freetime = service.getFreetime(schedules);
        List<Integer> res = IntStream.range(1, 24).boxed().filter(i->freetime.get(i-1)).toList();
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

}