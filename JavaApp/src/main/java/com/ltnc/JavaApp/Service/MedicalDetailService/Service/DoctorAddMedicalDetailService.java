package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorAddMedicalDetailService extends AbstractAddMedicalDetailService<Doctor>{

    @Autowired
    public DoctorAddMedicalDetailService(DoctorRepository doctorRepository, MedicalDetailRepository medicalDetailRepository) {
        this.medicalDetailRepository=medicalDetailRepository;
        this.modelRepository=doctorRepository;
        this.type = Doctor.class;

    }

}
