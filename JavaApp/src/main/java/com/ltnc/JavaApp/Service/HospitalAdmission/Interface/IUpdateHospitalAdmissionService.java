package com.ltnc.JavaApp.Service.HospitalAdmission.Interface;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;
import com.ltnc.JavaApp.Model.PatientState;

public interface IUpdateHospitalAdmissionService {
    public void updateStateHospitalAdmissionService(PatientState patientState,String detailId);
}
