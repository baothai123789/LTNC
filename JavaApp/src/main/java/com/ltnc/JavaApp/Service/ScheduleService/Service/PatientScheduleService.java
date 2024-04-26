package com.ltnc.JavaApp.Service.ScheduleService.Service;

import java.time.LocalDate;
import java.util.UUID;
import com.ltnc.JavaApp.Model.*;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.PatientProfileManageService;
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
    EmployeeProfileManageService employeeProfileManageService;
    @Autowired
    PatientProfileManageService patientProfileManageService;
    @Autowired
    PatientScheduleDTOMapper patientScheduleDTOMapper;
    @Autowired
    ScheduleNotifyService scheduleNotifyService;
    @Autowired
    private ScheduleMangeService scheduleMangeService;

    @Override
    public PatientScheduleDTO patientSchedule(LocalDate date, String doctorId,String patientId,int startTime) throws NullPointerException {
        Patient patient = patientProfileManageService.getProfile(patientId);
        Doctor doctor = (Doctor) employeeProfileManageService.getEmployeeProfile(doctorId,"doctor");
        Schedule newSchedule = new Schedule(
                UUID.randomUUID().toString(),date,startTime,startTime+1,"Lịch tái khám"
        );
        MyApp.LOGGER.info(newSchedule);
        scheduleMangeService.addSchedule(newSchedule,doctor);
        scheduleMangeService.addSchedule(newSchedule,patient);
        scheduleNotifyService.sendNotifyPatient(patient,newSchedule);
        employeeProfileManageService.UpdateUserProfile(doctor);
        patientProfileManageService.updateUserProfile(patient);
        scheduleNotifyService.sendNotifytoDoctor(doctor,patientId,newSchedule);
        return patientScheduleDTOMapper.map(newSchedule,doctor);
    }

}

