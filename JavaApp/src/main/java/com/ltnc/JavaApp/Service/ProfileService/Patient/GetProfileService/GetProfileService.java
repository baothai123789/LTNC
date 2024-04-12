package com.ltnc.JavaApp.Service.ProfileService.Patient.GetProfileService;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetProfileService implements IGetProfileService {

    @Autowired
    PatientRepository patientRepository;
    @Override
    public Patient getProfile(String id) throws NullPointerException {
        return patientRepository.findById(id).orElseThrow(NullPointerException::new);
    }
    @Override
    public String getType() {
        return "patient";
    }
}
