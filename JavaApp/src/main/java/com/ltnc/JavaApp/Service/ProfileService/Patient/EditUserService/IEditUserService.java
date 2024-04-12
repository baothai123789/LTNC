package com.ltnc.JavaApp.Service.ProfileService.Patient.EditUserService;

import com.ltnc.JavaApp.Model.Patient;

public interface IEditUserService {
    public void editUser(String id, Patient patient);
    public String getType();
}
