package com.ltnc.JavaApp.Service.ProfileService.CreateUserService.EditProfileService.Patient.Interface;

import com.ltnc.JavaApp.Model.Patient;

public interface IPatientEditProfileService {
    public String editProfile(String userId,Patient newprofile);
}