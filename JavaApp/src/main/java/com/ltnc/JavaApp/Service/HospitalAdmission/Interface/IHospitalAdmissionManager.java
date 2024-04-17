package com.ltnc.JavaApp.Service.HospitalAdmission.Interface;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;
import com.ltnc.JavaApp.Model.Nurse;

import java.util.List;

public interface IHospitalAdmissionManager {
    public int getPatientAmount();
    public void addHospitalAdmissionDetail(HospitalAdmissionDetail hospitalAdmissionDetail);
    public List<HospitalAdmissionDetail> getHospitalAdmissionDetails();
    public void updateHospitalAdmission(HospitalAdmissionDetail hospitalAdmissionDetail);
    public void removeHospitalAdmission(String detailId);

}
