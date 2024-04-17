package com.ltnc.JavaApp.Service.HospitalAdmission.Interface;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.HospitalAdmissionDetailDTO;

import java.time.LocalDate;
import java.util.List;

public interface IHospitalAdmissionManageService {
    public void addHospitalAdmission(HospitalAdmissionDetail newHospitalAdmission, Nurse nurse);
    public void removeHospitalAdmission(String hospitalAdmissionDetailId,String modelId);
    public void updateHopitalAdmissionState(String hospitalAdmissionId, String state, LocalDate date);
    public List<HospitalAdmissionDetailDTO> getHospitalAdmissionDetails(String modelId);
}
