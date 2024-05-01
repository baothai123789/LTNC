package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.DoctorMedicalDetailDTOMapper;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.IMedicalDetailDTO;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.PatientProfileManageService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorGetMedicalDetailService implements  IGetMedicalDetailService{
    @Resource
    PatientProfileManageService patientProfileManageService;
    @Resource
    EmployeeProfileManageService employeeProfileManageService;
    @Resource
    DoctorMedicalDetailDTOMapper doctorMedicalDetailDTOMapper;
    @Override
    public List<IMedicalDetailDTO> getMedicalDetail(String userId) {
        Doctor  doctor = (Doctor) employeeProfileManageService.getEmployeeProfile(userId,"doctor");
        return doctor.getMedicalDetails().stream().map(
                medicalDetail -> doctorMedicalDetailDTOMapper.map(
                        medicalDetail,null,
                        patientProfileManageService.getProfile(medicalDetail.getPatientId())
                )
        ).toList();
    }

    @Override
    public String getType() {
        return "doctor";
    }
}
