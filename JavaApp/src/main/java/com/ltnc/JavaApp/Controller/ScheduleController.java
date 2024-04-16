package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.RequestModel.ScheduleRequestModel.PatientScheduleRequest;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.PatientScheduleDTO;
import com.ltnc.JavaApp.Service.ScheduleService.Service.PatientScheduleService;
import com.ltnc.JavaApp.Service.ScheduleService.Service.ScheduleMangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAuthority('patient')")
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

    @PreAuthorize("hasAuthority('doctor')")
    @GetMapping("/doctor/{id}")
    private ResponseEntity<List<Schedule>> getDoctorSchedule(@PathVariable("id") String doctorId){
        List<Schedule> res = scheduleMangeService.getSchedulesbyDate(doctorId, LocalDate.parse("2022-04-22"),"patient");
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('doctor')")
    @PostMapping("/addschedule/doctor/{id}")
    private ResponseEntity<Map<String,String>> addDoctorSchedule(@PathVariable("id") String doctorId,@RequestBody Schedule newSchedule){
        try {
            scheduleMangeService.addSchedule(newSchedule, doctorId, "doctor");
        }
        catch (Exception e){
            return new ResponseEntity<>(new HashMap<>(Map.of("message","user not found")),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.CREATED);
    }
    @PreAuthorize("hasAuthority('patient')")
    @PostMapping("/addschedule/patient/{id}")
    private ResponseEntity<Map<String,String>> addPatientSchedule(@RequestBody Schedule newSchedule,@PathVariable("id") String patientId){
        scheduleMangeService.addSchedule(newSchedule,patientId,"patient");
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.CREATED);
    }
    @PreAuthorize("hasAuthority('patient')")
    @GetMapping("//patient/{id}")
    private ResponseEntity<Map<String,String>> addPatientSchedule(@PathVariable("id") String patientId,@RequestBody Schedule newschedule){
        scheduleMangeService.addSchedule(newschedule,patientId,"patient");
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.CREATED);
    }

}