package com.ltnc.JavaApp.Service.HospitalAdmission.Service;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Repository.HospitalAdmissionDetailRepository;
import com.ltnc.JavaApp.Repository.NurseRepository;
import com.ltnc.JavaApp.Service.HospitalAdmission.Interface.IAddHospitalAdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NurseAddHospitalAdmissionService implements IAddHospitalAdmissionService {
    @Autowired
    NurseRepository nurseRepository;
    @Autowired
    HospitalAdmissionDetailRepository hospitalAdmissionDetailRepository;

    @Override
    public void addHospitalAdmission(HospitalAdmissionDetail newHospitalAdmission, String modelId) throws NullPointerException {
        Nurse hospitalAdmissionManager = nurseRepository.findById(modelId).orElseThrow(NullPointerException::new);
        hospitalAdmissionManager.addHospitalAdmissionDetail(newHospitalAdmission);
        nurseRepository.save(hospitalAdmissionManager);
        hospitalAdmissionDetailRepository.save(newHospitalAdmission);
    }
}
