package com.ltnc.JavaApp.Service.ProfileService.Patient.GetProfileService;

import com.ltnc.JavaApp.Model.Patient;

public interface IGetProfileService {
    public Patient getProfile(String id);
    public String getType();
}
