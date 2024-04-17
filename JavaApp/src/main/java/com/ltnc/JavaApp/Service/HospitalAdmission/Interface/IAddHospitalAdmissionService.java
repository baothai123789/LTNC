package com.ltnc.JavaApp.Service.HospitalAdmission.Interface;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;
import com.ltnc.JavaApp.Model.Nurse;

public interface IAddHospitalAdmissionService {
    public void addHospitalAdmission(HospitalAdmissionDetail newHospitalAdmission,Nurse nurse);
}
