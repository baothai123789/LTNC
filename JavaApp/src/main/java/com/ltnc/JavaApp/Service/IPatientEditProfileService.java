package com.ltnc.JavaApp.Service;

import com.ltnc.JavaApp.Model.Patient;

public interface IPatientEditProfileService {
    public String editProfile(String userId,Patient newprofile);
}