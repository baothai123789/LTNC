package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.IMedicalDetailDTO;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.PatientMedicalDetailDTOMapper;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import com.ltnc.JavaApp.Service.ProfileService.Employee.IEmployeeProfileMangeService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.IPatientProfileManageService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.PatientProfileManageService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientGetMedicalDetailService implements IGetMedicalDetailService{
   @Resource
   IPatientProfileManageService patientProfileManageService;
   @Resource
   IEmployeeProfileMangeService employeeProfileManageService;
   @Resource
   PatientMedicalDetailDTOMapper patientMedicalDetailDTOMapper;

    @Override
    public List<IMedicalDetailDTO> getMedicalDetail(String userId) {
        Patient patient = patientProfileManageService.getProfile(userId);
        return patient.getMedicalDetails().stream().map(
                medicalDetail -> patientMedicalDetailDTOMapper.map(
                        medicalDetail,(Doctor) employeeProfileManageService.getEmployeeProfile(medicalDetail.getDoctorId(),"doctor"),
                        null
                )
        ).toList();
    }

    @Override
    public String getType() {
        return "patient";
    }
}
