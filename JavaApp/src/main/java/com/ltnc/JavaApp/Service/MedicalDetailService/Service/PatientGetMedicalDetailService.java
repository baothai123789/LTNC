package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.IMedicalDetailDTO;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.PatientMedicalDetailDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientGetMedicalDetailService implements IGetMedicalDetailService{
   @Autowired
   PatientRepository patientRepository;
   @Autowired
   DoctorRepository doctorRepository;
   @Autowired
   PatientMedicalDetailDTOMapper patientMedicalDetailDTOMapper;

    @Override
    public List<IMedicalDetailDTO> getMedicalDetail(String userId) {
        Patient patient = patientRepository.findById(userId).orElseThrow(()->new NullPointerException("user not found"));
        return patient.getMedicalDetails().stream().map(
                medicalDetail -> patientMedicalDetailDTOMapper.map(
                        medicalDetail,doctorRepository.findById(medicalDetail.getDoctorId()).orElseThrow(()->new NullPointerException("doctor not found")),
                        null
                )
        ).toList();
    }

    @Override
    public String getType() {
        return "patient";
    }
}
