package com.ltnc.JavaApp.Service.HospitalAdmission.Interface;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.HospitalAdmissionDetailDTO;

import java.util.List;

public interface IGetHospitalAdmissionService {
    public List<HospitalAdmissionDetailDTO> getHospitalAdmissions(String id, boolean done);
}
