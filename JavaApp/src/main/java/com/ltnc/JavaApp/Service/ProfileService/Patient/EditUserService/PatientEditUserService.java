package com.ltnc.JavaApp.Service.ProfileService.Patient.EditUserService;

import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.PatientRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientEditUserService implements IEditUserService{
    @Resource
    PatientRepository patientRepository;
    @Override
    public void editUser(String id, Patient patient) {
        patient.setId(id);
        Patient patient_db=patientRepository.findById(id).orElseThrow(NullPointerException::new);
        patient_db.getSchedules().forEach(patient::addSchedule);
        patient_db.getMedicalDetails().forEach(patient::addMedicalDetail);
        patient.setUserAccount(patient_db.getUserAccount());
        patientRepository.save(patient);
    }

    @Override
    public String getType() {
        return "patient";
    }

    @Override
    public void updateUser(Patient patient) {
        this.patientRepository.save(patient);
    }
}
