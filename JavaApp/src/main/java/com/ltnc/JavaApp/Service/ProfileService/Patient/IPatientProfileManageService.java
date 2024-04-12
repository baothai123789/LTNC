package com.ltnc.JavaApp.Service.ProfileService.Patient;

import com.ltnc.JavaApp.Model.Patient;

public interface IPatientProfileManageService {
    public void createProfile(Patient newpPatient);
    public void editProfile(String modelId,Patient patient);
    public Patient getProfile(String id);

}
