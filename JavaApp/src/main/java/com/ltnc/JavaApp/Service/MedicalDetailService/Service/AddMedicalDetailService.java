package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import java.util.List;
import java.util.ArrayList;
import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.IAddMedicalDetailService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddMedicalDetailService implements IAddMedicalDetailService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;
    private void addDetail(MedicalDetailModel medicalDetailModel, MedicalDetail medicalDetail) {
        medicalDetailModel.addMedicalDetail(medicalDetail);
    }
    @Override
    public List<MedicalDetailModel> addMedicalDetail(String doctorId, String patientId, MedicalDetail medicalDetail) {
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        if(doctor == null) { return null;}
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if(patient == null) { return null;}
        this.addDetail(doctor,medicalDetail);
        this.doctorRepository.save(doctor);
        this.addDetail(patient,medicalDetail);
        this.patientRepository.save(patient);
        return new ArrayList<>(List.of(doctor,patient));

    }
}

