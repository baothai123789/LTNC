package com.ltnc.JavaApp.Service.ProfileService.Patient.EditUserService;

import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientEditUserService implements IEditUserService{
    @Autowired
    PatientRepository patientRepository;
    @Override
    public void editUser(String id, Patient patient) {
        patient.setId(id);
        patientRepository.save(patient);
    }

    @Override
    public String getType() {
        return "patient";
    }
}
