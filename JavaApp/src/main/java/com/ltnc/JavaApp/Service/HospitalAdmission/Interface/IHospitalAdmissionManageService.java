package com.ltnc.JavaApp.Service.HospitalAdmission.Interface;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;

import java.time.LocalDate;
import java.util.List;

public interface IHospitalAdmissionManageService {
    public void addHospitalAdmission(HospitalAdmissionDetail newHospitalAdmission,String modelId);
    public void removeHospitalAdmission(String hospitalAdmissionDetailId,String modelId);
    public void updateHopitalAdmissionState(String hospitalAdmissionId, String state, LocalDate date);
    public List<HospitalAdmissionDetail> getHospitalAdmissionDetails(String modelId);
}
