package com.ltnc.JavaApp.Controller;
import java.time.LocalDate;
import java.util.List;

import com.ltnc.JavaApp.Service.ScheduleService.Interface.IGetDoctorScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IFindDoctorbyMajorService;
import com.ltnc.JavaApp.Model.Doctor;

@RestController
@RequestMapping("/schedule")
@Component
public class ScheduleController{
    @Autowired
    private IGetDoctorScheduleService service;

    @Autowired
    private IFindDoctorbyMajorService findDoctorbyMajorService;

    @GetMapping("/doctors/{major}")
    ResponseEntity<List<Doctor>> getDoctorsbyMajor(@PathVariable("major") String major){
        List<Doctor> doctors = findDoctorbyMajorService.findDoctor(major);
        return new ResponseEntity<>(doctors,doctors.isEmpty()?HttpStatus.NOT_FOUND:HttpStatus.OK);
    }

    @GetMapping("/getschedule/{doctor}/{date}")
    ResponseEntity<List<Integer>>getSchedule(@PathVariable("doctor") String doctorid,@PathVariable("date") String date){
        List<Integer> schedulesbyHour = service.getDoctorSchedule(doctorid,LocalDate.parse(date));
        return new ResponseEntity<>(schedulesbyHour,HttpStatus.OK);
    }

}