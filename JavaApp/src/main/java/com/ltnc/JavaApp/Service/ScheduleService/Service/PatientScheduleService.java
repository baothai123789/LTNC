package com.ltnc.JavaApp.Service.ScheduleService.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.ltnc.JavaApp.Model.*;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.PatientScheduleDTO;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.PatientScheduleDTOMapper;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IPatientScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PatientScheduleService implements IPatientScheduleService {
    @Autowired
    FindDoctorScheduleService findDoctorScheduleService;
    @Autowired
    NotificationManage notificationManage;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    PatientScheduleDTOMapper patientScheduleDTOMapper;
    @Autowired
    ScheduleNotifyService scheduleNotifyService;

    @Override
    public PatientScheduleDTO patientSchedule(LocalDate date, String doctorId,String patientId,int startTime) throws NullPointerException {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new NullPointerException("patient not found"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()->new NullPointerException("Doctor not found"));
        MyApp.LOGGER.info(patient);
        MyApp.LOGGER.info(doctor);
        Schedule newSchedule = new Schedule(
                UUID.randomUUID().toString(),date,startTime,startTime+1,"Lịch tái khám"
        );
        MyApp.LOGGER.info(newSchedule);
        doctor.addSchedule(newSchedule);
        patient.addSchedule(newSchedule);
        scheduleRepository.save(newSchedule);
        scheduleNotifyService.sendNotifyPatient(patient,newSchedule);
        scheduleNotifyService.sendNotifytoDoctor(doctor,patientId,newSchedule);
        return patientScheduleDTOMapper.map(newSchedule,doctor);
    }

}

