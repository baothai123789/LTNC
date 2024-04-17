package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.DoctorMedicalDetailDTOMapper;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.IMedicalDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorGetMedicalDetailService implements  IGetMedicalDetailService{
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    DoctorMedicalDetailDTOMapper doctorMedicalDetailDTOMapper;
    @Override
    public List<IMedicalDetailDTO> getMedicalDetail(String userId) {
        Doctor  doctor = doctorRepository.findById(userId).orElseThrow(()->new NullPointerException("user not found"));
        return doctor.getMedicalDetails().stream().map(
                medicalDetail -> doctorMedicalDetailDTOMapper.map(
                        medicalDetail,null,
                        patientRepository.findById(medicalDetail.getPatientId()).orElseThrow(()->new NullPointerException("patient not found"))
                )
        ).toList();
    }

    @Override
    public String getType() {
        return "doctor";
    }
}
