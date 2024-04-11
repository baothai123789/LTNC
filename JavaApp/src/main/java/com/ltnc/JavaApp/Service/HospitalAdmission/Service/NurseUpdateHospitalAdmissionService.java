package com.ltnc.JavaApp.Service.HospitalAdmission.Service;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;
import com.ltnc.JavaApp.Model.PatientState;
import com.ltnc.JavaApp.Repository.HospitalAdmissionDetailRepository;
import com.ltnc.JavaApp.Service.HospitalAdmission.Interface.IUpdateHospitalAdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NurseUpdateHospitalAdmissionService implements IUpdateHospitalAdmissionService {
    @Autowired
    HospitalAdmissionDetailRepository hospitalAdmissionDetailRepository;
    @Override
    public void updateStateHospitalAdmissionService(PatientState patientState, String detailId) throws NullPointerException {
        HospitalAdmissionDetail hospitalAdmissionDetail = hospitalAdmissionDetailRepository.findById(detailId).orElseThrow(NullPointerException::new);
        hospitalAdmissionDetail.addPatientState(patientState);
        hospitalAdmissionDetailRepository.save(hospitalAdmissionDetail);
    }
}
