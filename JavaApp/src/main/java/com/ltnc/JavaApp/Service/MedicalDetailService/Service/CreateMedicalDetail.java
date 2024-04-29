package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
import com.ltnc.JavaApp.Service.FinancialService.CreateNewMedicalBillService;
import com.ltnc.JavaApp.Service.FinancialService.MedicalBillManage;
import com.ltnc.JavaApp.Service.FinancialService.PatientInfoDTO;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.PatientProfileManageService;
import com.ltnc.JavaApp.Service.ScheduleService.Service.ScheduleMangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CreateMedicalDetail {

    @Autowired
    NotifyMedicalDetailService notifyMedicalDetailService;
    @Autowired
    ScheduleMedicalDetailService scheduleMedicalDetailService;
    @Autowired
    PatientProfileManageService patientProfileManageService;
    @Autowired
    EmployeeProfileManageService employeeProfileManageService;
    @Autowired
    IMedicalDetailManageService medicalDetailManageService;
    @Autowired
    CreateNewMedicalBillService createNewMedicalBillService;
    @Autowired
    ScheduleMangeService scheduleMangeService;
    public void createMedicalDetail(String doctorid, String patientId, MedicalDetail medicalDetail)throws NullPointerException{
        medicalDetail.setId(UUID.randomUUID().toString());
        Doctor doctor;
        Patient patient;
        doctor =(Doctor) employeeProfileManageService.getEmployeeProfile(doctorid,"doctor");
        patient =(Patient) patientProfileManageService.getProfile(patientId);
        medicalDetailManageService.addMedicalDetail(medicalDetail,doctor);
        medicalDetailManageService.addMedicalDetail(medicalDetail,patient);
        List<Schedule> schedules=scheduleMedicalDetailService.createMedicalSchedule(doctor,patient,medicalDetail.getMedicalSchedules());
        for(Schedule schedule:schedules){
            scheduleMangeService.addSchedule(schedule,doctor);
            scheduleMangeService.addSchedule(schedule,patient);
            notifyMedicalDetailService.sendNotifytoPatient(patient,schedule,medicalDetail.getId());
            notifyMedicalDetailService.sendNotifytoDoctor(doctor,schedule,patientId,medicalDetail.getId());
        }
        patientProfileManageService.updateUserProfile(patient);
        employeeProfileManageService.UpdateUserProfile(doctor);
        createNewMedicalBillService.createNewMedicalBill(medicalDetail,null,patient,"medicaldetailbill");
    }
}
