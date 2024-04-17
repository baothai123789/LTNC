package com.ltnc.JavaApp.Service.ScheduleService.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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


    private void sendNotifytoDoctor(Doctor doctor,String patientId,Schedule schedule){
        Notification notification = new Notification();
        notification.setBody("Bạn có lịch khám bệnh từ bệnh nhân: "+patientId+
                " vào lúc "+schedule.getStartTime()+" ngày "+schedule.getDate());
        notification.setTitle("Lịch khám bệnh");
        notification.setDateTime(LocalDateTime.now());

        notificationManage.sendNotification(notification,doctor);
    }
    private void sendNotifyPatient(Patient patient,Schedule schedule){
        Notification notification_patient = new Notification();
        notification_patient.setBody(
                "Bạn có lịch khám bệnh vào lúc"+schedule.getStartTime()
                        +" ngày "+schedule.getDate()+
                        ". Mã lịch hẹn:"+ schedule.getId()
        );
        notification_patient.setTitle("Lịch Khám Bệnh");
        notification_patient.setDateTime(LocalDateTime.now());
        notificationManage.sendNotification(notification_patient,patient);
    }

    @Override
    public PatientScheduleDTO patientSchedule(LocalDate date, String doctorId,String patientId) throws NullPointerException {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new NullPointerException("patient not found"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()->new NullPointerException("Doctor not found"));
        MyApp.LOGGER.info(patient);
        MyApp.LOGGER.info(doctor);
        Schedule newSchedule = findDoctorScheduleService.getSchedules(doctor,date);
        MyApp.LOGGER.info(newSchedule);
        doctor.addSchedule(newSchedule);
        patient.addSchedule(newSchedule);
        scheduleRepository.save(newSchedule);
        sendNotifyPatient(patient,newSchedule);
        sendNotifytoDoctor(doctor,patientId,newSchedule);
        return patientScheduleDTOMapper.map(newSchedule,doctor);

    }

}

