package com.ltnc.JavaApp.Service.HospitalAdmission.Service;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.*;
import com.ltnc.JavaApp.Service.HospitalAdmission.Interface.IAddHospitalAdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NurseAddHospitalAdmissionService implements IAddHospitalAdmissionService {
    @Autowired
    HospitalAdmissionDetailRepository hospitalAdmissionDetailRepository;
    @Autowired
    MedicalDetailRepository medicalDetailRepository;
    @Autowired
    NurseRepository nurseRepository;
    @Override
    public void addHospitalAdmission(HospitalAdmissionDetail newHospitalAdmission, Nurse nurse) throws NullPointerException {
        MedicalDetail medicalDetail = medicalDetailRepository.findById(newHospitalAdmission.getMedicalDetail()
                .getId()).orElseThrow(()->new NullPointerException("cannot find medicaldetail"));
        newHospitalAdmission.setMedicalDetail(medicalDetail);
        newHospitalAdmission.setId(UUID.randomUUID().toString());
        nurse.addHospitalAdmissionDetail(newHospitalAdmission);
        MyApp.LOGGER.info(nurse);
        nurseRepository.save(nurse);
    }
}
