package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.*;
import com.ltnc.JavaApp.Service.MedicalDetailService.Service.MedicalDetailManageService;
import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.ICreateMedicalDetailService;
import com.ltnc.JavaApp.Service.ScheduleService.Service.ScheduleMangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CreateMedicalDetailService implements ICreateMedicalDetailService {
    @Autowired
    private MedicalDetailManageService medicalDetailManageService;
    @Autowired
    private ScheduleMangeService scheduleMangeService;
    @Autowired
    private NotificationManage notificationManage;
    private void createSchedule(List<MedicalSchedule> scheduleList,String doctorId,String patientId){
        for(MedicalSchedule schedule:scheduleList){
            Schedule scheduleObj = new Schedule(UUID.randomUUID().toString(),
                    schedule.getTime().toLocalDate(),schedule.getTime().getHour(),schedule.getTime().getHour()+1,schedule.getDetail(),
                    patientId,doctorId);
            scheduleMangeService.addSchedule(scheduleObj,doctorId,"doctor");
            scheduleMangeService.addSchedule(scheduleObj,patientId,"patient");
        }
    }
    private void sendNotification(List<MedicalSchedule> scheduleList,String doctorId,String patientId,String medicalId){
        for(MedicalSchedule schedule:scheduleList) {
            Person doctor = new Doctor();
            Person patient = new Patient();
            doctor.setId(doctorId);
            patient.setId(patientId);
            Notification doctorNotification = new Notification(
                    doctor, "Tai kham", "Ban co lich tai kham. Ma ho so kham benh:"
                    +medicalId,schedule.getTime());
            Notification patientNotification1 = new Notification(
                    patient,"Tai kham","Ban co lich tai kham. Ma ho so kham benh:"
                    +medicalId,schedule.getTime());
            notificationManage.sendNotification(doctorNotification);
            notificationManage.sendNotification(patientNotification1);
        }
    }

    @Override
    public void createMedicalDetail(MedicalDetail medicalDetail, String doctorId, String patientId) throws NullPointerException {
        medicalDetail.setId(UUID.randomUUID().toString());
        medicalDetail.setDoctorId(doctorId);
        medicalDetail.setPatientId(patientId);
        try {
            this.medicalDetailManageService.addMedicalDetail(medicalDetail, doctorId, "doctor");
            this.medicalDetailManageService.addMedicalDetail(medicalDetail, patientId, "patient");
        }
        catch (NullPointerException e) {
            throw  new NullPointerException("user not found");
        }
        this.createSchedule(medicalDetail.getMedicalSchedules(),doctorId,patientId);
        this.sendNotification(medicalDetail.getMedicalSchedules(),doctorId,patientId,medicalDetail.getId());
    }
}
