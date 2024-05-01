package com.ltnc.JavaApp.Service.HospitalAdmission.Service;

import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Repository.NurseRepository;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindNurseService {
    @Resource
    NurseRepository nurseRepository;
    Nurse findNurse(){
        List<Nurse> nurses = nurseRepository.findAll();
        return nurses.stream().filter(nurse -> nurse.getHospitalAdmissionDetails().size()<10).findFirst().orElseThrow(NullPointerException::new);
    }


}
