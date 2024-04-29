package com.ltnc.JavaApp.Service.HospitalAdmission.Service;


import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.HospitalAdmissionDetailRepository;
import com.ltnc.JavaApp.Repository.NurseRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.HospitalAdmissionDTOMapper;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.HospitalAdmissionDetailDTO;
import com.ltnc.JavaApp.Service.HospitalAdmission.Interface.IGetHospitalAdmissionService;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.PatientProfileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NurseGetHospitalAdmissionService implements IGetHospitalAdmissionService {
    @Autowired
    HospitalAdmissionDetailRepository hospitalAdmissionDetailRepository;
    @Autowired
    PatientProfileManageService patientProfileManageService;
    @Autowired
    EmployeeProfileManageService employeeProfileManageService;
    @Autowired
    HospitalAdmissionDTOMapper hospitalAdmissionDTOMapper;
    @Override
    public List<HospitalAdmissionDetailDTO> getHospitalAdmissions(String modelId, boolean done) throws NullPointerException {
        Nurse nurse = (Nurse) employeeProfileManageService.getEmployeeProfile(modelId,"nurse");
        return nurse.getHospitalAdmissionDetails().stream()
                .map(hospitalAdmissionDetail ->
                        hospitalAdmissionDTOMapper.map(
                                hospitalAdmissionDetail,
                                patientProfileManageService.getProfile(hospitalAdmissionDetail.getPatientId()),
                                (Doctor) employeeProfileManageService.getEmployeeProfile(hospitalAdmissionDetail.getDoctorId(),"doctor")
                        )).toList();

    }
}
