package com.ltnc.JavaApp.Service.ProfileService.Patient;

import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Service.ProfileService.Patient.CreateUSerService.IPatientCreateUserService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.EditUserService.IEditUserService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.GetProfileService.IGetProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientProfileManageService implements IPatientProfileManageService{
    @Autowired
    IPatientCreateUserService patientCreateUserService;
    @Autowired
    IEditUserService editUserService;
    @Autowired
    IGetProfileService getProfileService;

    @Override
    public void createProfile(Patient newpPatient) {
        patientCreateUserService.createUser(newpPatient);
    }

    @Override
    public void editProfile(String modelId, Patient patient) {
        editUserService.editUser(modelId,patient);
    }

    @Override
    public Patient getProfile(String id) throws NullPointerException {
        Patient res;
        try{
            res=this.getProfileService.getProfile(id);
        }
        catch (NullPointerException e){
            throw new NullPointerException("user not found");
        }
        return res;
    }
}
