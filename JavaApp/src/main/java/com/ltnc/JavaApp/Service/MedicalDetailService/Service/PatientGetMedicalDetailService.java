package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientGetMedicalDetailService extends AbstractGetMedicalDetailService<Patient> {
    @Autowired
    public PatientGetMedicalDetailService(PatientRepository patientRepository, MedicalDetailRepository medicalDetailRepository) {
        this.medicalDetailRepository  = medicalDetailRepository;
        this.modelRepository= patientRepository;
        this.type = Patient.class;
    }
}

