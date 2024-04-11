package com.ltnc.JavaApp.Service.HospitalAdmission.Interface;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;

import java.util.List;

public interface IGetHospitalAdmissionService {
    public List<HospitalAdmissionDetail> getHospitalAdmissions(String id,boolean done);
}
