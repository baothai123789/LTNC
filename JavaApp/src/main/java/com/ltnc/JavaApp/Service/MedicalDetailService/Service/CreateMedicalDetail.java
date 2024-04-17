package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Repository.ScheduleRepository;
import com.ltnc.JavaApp.Service.FinancialService.PatientInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CreateMedicalDetail {
    @Autowired
    MedicalDetailRepository medicalDetailRepository;
    @Autowired
    NotifyMedicalDetailService notifyMedicalDetailService;
    @Autowired
    ScheduleMedicalDetailService scheduleMedicalDetailService;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;
    public void createMedicalDetail(String doctorid, String patientId, MedicalDetail medicalDetail){
        medicalDetail.setId(UUID.randomUUID().toString());
        Doctor doctor =doctorRepository.findById(doctorid).orElseThrow(()->new NullPointerException("doctor not found"));
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new NullPointerException("patient not found"));
        doctor.addMedicalDetail(medicalDetail);
        patient.addMedicalDetail(medicalDetail);
        medicalDetailRepository.save(medicalDetail);
        List<Schedule> schedules=scheduleMedicalDetailService.createMedicalSchedule(doctor,patient,medicalDetail.getMedicalSchedules());
        scheduleRepository.saveAll(schedules);
        for(Schedule schedule:schedules){
            notifyMedicalDetailService.sendNotifytoPatient(patient,schedule,medicalDetail.getId());
            notifyMedicalDetailService.sendNotifytoDoctor(doctor,schedule,patientId,medicalDetail.getId());
        }
    }
}
