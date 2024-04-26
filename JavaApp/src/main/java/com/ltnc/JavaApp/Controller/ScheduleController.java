package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.RequestModel.ScheduleRequestModel.PatientScheduleRequest;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.DoctorInfoScheduleDTO;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.DoctorScheduleDTO;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.PatientScheduleDTO;
import com.ltnc.JavaApp.Service.ScheduleService.Exception.DoctorMajorNotfoundException;
import com.ltnc.JavaApp.Service.ScheduleService.Service.FindDoctorScheduleService;
import com.ltnc.JavaApp.Service.ScheduleService.Service.PatientScheduleService;
import com.ltnc.JavaApp.Service.ScheduleService.Service.ScheduleMangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleConsumer;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    ScheduleMangeService scheduleMangeService;
    @Autowired
    PatientScheduleService patientScheduleService;
    @Autowired
    FindDoctorScheduleService findDoctorScheduleService;
    @PreAuthorize("hasAuthority('patient')")
    @PostMapping("/createschedule")
    public ResponseEntity<PatientScheduleDTO> createPatientSchedule(@RequestBody PatientScheduleRequest patientScheduleRequest){
        MyApp.LOGGER.info(patientScheduleRequest);
        PatientScheduleDTO res = patientScheduleService.patientSchedule(
                patientScheduleRequest.getDate(),
                patientScheduleRequest.getDoctorId(),
                patientScheduleRequest.getPatientId(),
                patientScheduleRequest.getStartTime()
        );
        MyApp.LOGGER.info(res);
        return new ResponseEntity<>(res,res==null? HttpStatus.NOT_FOUND:HttpStatus.CREATED);
    }
    @PreAuthorize("hasAuthority('patient')")
    @GetMapping("/getdoctorschedule/{major}/{date}")
    public ResponseEntity<?> getDoctorSchedule(@PathVariable("major") String major,@PathVariable("date") String date){
        try{
            major=major.replace("_"," ");
            List<DoctorInfoScheduleDTO> res = findDoctorScheduleService.getDoctorSchedule(LocalDate.parse(date),major);
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
        catch (DoctorMajorNotfoundException e){
            return new ResponseEntity<>(new HashMap<>(Map.of("message",e.getMessage())),HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
