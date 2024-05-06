package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Service.FinancialService.CreateMedicalBillAdapter;
import com.ltnc.JavaApp.Service.NotificationService.NotifyObserver;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.PatientProfileManageService;
import com.ltnc.JavaApp.Service.ScheduleService.Service.ScheduleMangeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CreateMedicalDetail {

    @Resource
    NotifyObserver notifyObserver;
    @Resource
    ScheduleMedicalDetailService scheduleMedicalDetailService;
    @Resource
    PatientProfileManageService patientProfileManageService;
    @Resource
    EmployeeProfileManageService employeeProfileManageService;
    @Resource
    IMedicalDetailManageService medicalDetailManageService;
    @Resource
    CreateMedicalBillAdapter createMedicalBillAdapter;
    @Resource
    ScheduleMangeService scheduleMangeService;

    public void createMedicalDetail(String doctorid, String patientId, MedicalDetail medicalDetail)throws NullPointerException{
        medicalDetail.setId(UUID.randomUUID().toString());
        Doctor doctor;
        Patient patient;
        doctor =(Doctor) employeeProfileManageService.getEmployeeProfile(doctorid,"doctor");
        patient =patientProfileManageService.getProfile(patientId);
        medicalDetailManageService.addMedicalDetail(medicalDetail,doctor);
        medicalDetailManageService.addMedicalDetail(medicalDetail,patient);
        List<Schedule> schedules=scheduleMedicalDetailService.createMedicalSchedule(doctor,patient,medicalDetail.getMedicalSchedules());

        for(Schedule schedule:schedules){
            MyApp.LOGGER.info("loop schedule");
            Map<String,Object> detail=new HashMap<>(Map.of(
                    "scheduleId",schedule.getId(),
                    "scheduleDate",schedule.getDate(),
                    "scheduleTime",schedule.getStartTime()));
            scheduleMangeService.addSchedule(schedule,doctor);
            scheduleMangeService.addSchedule(schedule,patient);
            notifyObserver.notifyListener("schedule",detail);
            notifyObserver.clearListener("schedule");
        }
        patientProfileManageService.updateUserProfile(patient);
        employeeProfileManageService.UpdateUserProfile(doctor);
        Map<String,Object> dataforMedicalBill = new HashMap<>(Map.of(
                "type","medicaldetailbill",
                "medicalDetail",medicalDetail
        ));
        createMedicalBillAdapter.createMedicalBill(dataforMedicalBill,patient);
    }
}
