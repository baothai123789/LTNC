package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.RequestModel.ScheduleRequestModel.PatientScheduleRequest;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.PatientScheduleDTO;
import com.ltnc.JavaApp.Service.ScheduleService.Service.PatientScheduleService;
import com.ltnc.JavaApp.Service.ScheduleService.Service.ScheduleMangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    ScheduleMangeService scheduleMangeService;
    @Autowired
    PatientScheduleService patientScheduleService;
    @PreAuthorize("hasAuthority('patient')")

    @PostMapping("/createschedule")
    public ResponseEntity<PatientScheduleDTO> createPatientSchedule(@RequestBody PatientScheduleRequest patientScheduleRequest){
        MyApp.LOGGER.info(patientScheduleRequest);
        PatientScheduleDTO res = patientScheduleService.patientSchedule(
                patientScheduleRequest.getDate(),
                patientScheduleRequest.getDoctorId(),
                patientScheduleRequest.getPatientId()
        );
        MyApp.LOGGER.info(res);
        return new ResponseEntity<>(res,res==null? HttpStatus.NOT_FOUND:HttpStatus.CREATED);
    }
}
