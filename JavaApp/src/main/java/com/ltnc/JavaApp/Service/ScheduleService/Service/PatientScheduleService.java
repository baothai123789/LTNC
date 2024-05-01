package com.ltnc.JavaApp.Service.ScheduleService.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.ltnc.JavaApp.Model.*;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Service.NotificationService.NotifyListener;
import com.ltnc.JavaApp.Service.NotificationService.NotifyObserver;
import com.ltnc.JavaApp.Service.NotificationService.ScheduleNotifyListener;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.PatientProfileManageService;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.PatientScheduleDTOMapper;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.ScheduleDTO;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IPatientScheduleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;



@Service
public class PatientScheduleService implements IPatientScheduleService {

    @Resource
    EmployeeProfileManageService employeeProfileManageService;
    @Resource
    PatientProfileManageService patientProfileManageService;
    @Resource
    PatientScheduleDTOMapper patientScheduleDTOMapper;
    @Resource
    private ScheduleMangeService scheduleMangeService;
    @Resource
    NotifyObserver notifyObserver;

    private void sendNotify(Doctor doctor,Patient patient,Schedule schedule){
        NotifyListener patientNotifyListener = new ScheduleNotifyListener(patient);
        NotifyListener doctorNotifyListener = new ScheduleNotifyListener(doctor);
        Map<String,Object> detail=new HashMap<>(Map.of(
                "scheduleId",schedule.getId(),
                "scheduleDate",schedule.getDate(),
                "scheduleTime",schedule.getStartTime()));
        notifyObserver.addListener("schedule",patientNotifyListener);
        notifyObserver.addListener("schedule",doctorNotifyListener);
        notifyObserver.notifyListener("schedule",detail);
        notifyObserver.removeListener("schedule",doctorNotifyListener);
        notifyObserver.removeListener("schedule",patientNotifyListener);
    }
    @Override
    public ScheduleDTO patientSchedule(LocalDate date, String doctorId, String patientId, int startTime) throws NullPointerException {
        Patient patient = patientProfileManageService.getProfile(patientId);
        Doctor doctor = (Doctor) employeeProfileManageService.getEmployeeProfile(doctorId,"doctor");
        Schedule newSchedule = new Schedule(
                UUID.randomUUID().toString(),date,startTime,startTime+1,"Lịch tái khám",doctorId,
                patientId
        );
        MyApp.LOGGER.info(newSchedule);
        scheduleMangeService.addSchedule(newSchedule,doctor);
        scheduleMangeService.addSchedule(newSchedule,patient);
        sendNotify(doctor,patient,newSchedule);
        employeeProfileManageService.UpdateUserProfile(doctor);
        patientProfileManageService.updateUserProfile(patient);
        return patientScheduleDTOMapper.map(newSchedule,doctor);
    }

}

