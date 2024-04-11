package com.ltnc.JavaApp.Service.HospitalAdmission.Service;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Repository.HospitalAdmissionDetailRepository;
import com.ltnc.JavaApp.Repository.NurseRepository;
import com.ltnc.JavaApp.Service.HospitalAdmission.Interface.IGetHospitalAdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseGetHospitalAdmissionService implements IGetHospitalAdmissionService {
    @Autowired
    NurseRepository nurseRepository;
    @Autowired
    HospitalAdmissionDetailRepository hospitalAdmissionDetailRepository;
    @Override
    public List<HospitalAdmissionDetail> getHospitalAdmissions(String modelId, boolean done) throws NullPointerException {
        Nurse nurse = nurseRepository.findById(modelId).orElseThrow(NullPointerException::new);
        List<HospitalAdmissionDetail> res=new ArrayList<>();
        for(HospitalAdmissionDetail hospitalAdmissionDetail:nurse.getHospitalAdmissionDetails()){
            res.addAll(hospitalAdmissionDetailRepository.getHospitalAdmissionDetailsByDone(hospitalAdmissionDetail.getId(),done));
        }
        return res;
    }
}
