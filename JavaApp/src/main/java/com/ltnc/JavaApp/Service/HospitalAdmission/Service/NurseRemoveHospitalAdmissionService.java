package com.ltnc.JavaApp.Service.HospitalAdmission.Service;

import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Repository.HospitalAdmissionDetailRepository;
import com.ltnc.JavaApp.Repository.NurseRepository;
import com.ltnc.JavaApp.Service.HospitalAdmission.Interface.IRemoveHospitalAdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NurseRemoveHospitalAdmissionService implements IRemoveHospitalAdmissionService{
    @Autowired
    NurseRepository nurseRepository;
    @Autowired
    HospitalAdmissionDetailRepository hospitalAdmissionDetailRepository;
    @Override
    public void removeHospitalAdmissionService(String hospitalId, String modelId) throws NullPointerException {
        Nurse nurse = nurseRepository.findById(modelId).orElseThrow(NullPointerException::new);
        nurse.removeHospitalAdmission(hospitalId);
        nurseRepository.save(nurse);
        hospitalAdmissionDetailRepository.deleteById(hospitalId);
    }
}
