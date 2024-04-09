package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.RequestModel.ScheduleRequestModel.PatientScheduleRequest;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.PatientScheduleDTO;
import com.ltnc.JavaApp.Service.ScheduleService.Service.PatientScheduleService;
import com.ltnc.JavaApp.Service.ScheduleService.Service.ScheduleMangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/schedule")
@Component
public class ScheduleController{
    @Autowired
    PatientScheduleService patientScheduleService;
    @Autowired
    ScheduleMangeService scheduleMangeService;

    @PostMapping("/createschedule")
    private ResponseEntity<Object> createPatientSchedule(@RequestBody PatientScheduleRequest patientScheduleRequest){
        PatientScheduleDTO patientScheduleDTO = patientScheduleService.patientSchedule(
                patientScheduleRequest.getDate(),
                patientScheduleRequest.getDoctorId(),
                patientScheduleRequest.getPatientId()
        );
        return patientScheduleDTO==null?
                new ResponseEntity<>(new HashMap<>(Map.of("message","doctor schedule not found"+"in"+patientScheduleRequest.getDate().toString())), HttpStatus.NOT_ACCEPTABLE):
                new ResponseEntity<>(patientScheduleDTO,HttpStatus.CREATED);
    }
    @GetMapping("/patient/{id}")
    private ResponseEntity<List<Schedule>> getDoctorSchedule(@PathVariable("id") String doctorId){
        List<Schedule> res = scheduleMangeService.getSchedulesbyDate(doctorId, LocalDate.parse("2022-04-22"),"patient");
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    @PostMapping("/addschedule/patient/{id}")
    private ResponseEntity<String> addSchedule(@RequestBody Schedule newSchedule,@PathVariable("id") String patientId){
        scheduleMangeService.addSchedule(newSchedule,patientId,"patient");
        return new ResponseEntity<>("ok",HttpStatus.CREATED);
    }

}