package com.ltnc.JavaApp.Service.HospitalAdmission.Service;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;

import com.ltnc.JavaApp.Model.Nurse;

import com.ltnc.JavaApp.Repository.*;
import com.ltnc.JavaApp.Service.HospitalAdmission.Interface.IAddHospitalAdmissionService;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NurseAddHospitalAdmissionService implements IAddHospitalAdmissionService {
    @Resource
    HospitalAdmissionDetailRepository hospitalAdmissionDetailRepository;
    @Override
    public void addHospitalAdmission(HospitalAdmissionDetail newHospitalAdmission, Nurse nurse) throws NullPointerException {

        nurse.addHospitalAdmissionDetail(newHospitalAdmission);
        hospitalAdmissionDetailRepository.save(newHospitalAdmission);
    }
}
