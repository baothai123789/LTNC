package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import java.util.List;
import java.util.ArrayList;
import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.PatientState;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.IAddMedicalDetailService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;
import com.ltnc.JavaApp.Service.ScheduleService.Service.ScheduleMangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddMedicalDetailService implements IAddMedicalDetailService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    MedicalDetailRepository medicalDetailRepository;


    @Override
    public void addMedicalDetail(String doctorId, String patientId, MedicalDetail medicalDetail) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(NullPointerException::new);
        Patient patient = patientRepository.findById(patientId).orElseThrow(NullPointerException::new);
        doctor.addMedicalDetail(medicalDetail);
        patient.addMedicalDetail(medicalDetail);
        doctorRepository.save(doctor);
        patientRepository.save(patient);
        medicalDetailRepository.save(medicalDetail);
    }
}

