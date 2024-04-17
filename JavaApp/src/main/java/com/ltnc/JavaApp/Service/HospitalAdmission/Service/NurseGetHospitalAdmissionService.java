package com.ltnc.JavaApp.Service.HospitalAdmission.Service;


import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.HospitalAdmissionDetailRepository;
import com.ltnc.JavaApp.Repository.NurseRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.HospitalAdmissionDTOMapper;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.HospitalAdmissionDetailDTO;
import com.ltnc.JavaApp.Service.HospitalAdmission.Interface.IGetHospitalAdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NurseGetHospitalAdmissionService implements IGetHospitalAdmissionService {
    @Autowired
    NurseRepository nurseRepository;
    @Autowired
    HospitalAdmissionDetailRepository hospitalAdmissionDetailRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    HospitalAdmissionDTOMapper hospitalAdmissionDTOMapper;
    @Override
    public List<HospitalAdmissionDetailDTO> getHospitalAdmissions(String modelId, boolean done) throws NullPointerException {
        Nurse nurse = nurseRepository.findById(modelId).orElseThrow(NullPointerException::new);
        return nurse.getHospitalAdmissionDetails().stream()
                .map(hospitalAdmissionDetail ->
                        hospitalAdmissionDTOMapper.map(
                                hospitalAdmissionDetail,
                                patientRepository.findById(hospitalAdmissionDetail.getPatientId()).orElseThrow(()->new NullPointerException("patinet not found")),
                                doctorRepository.findById(hospitalAdmissionDetail.getDoctorId()).orElseThrow(()->new NullPointerException("doctor not found"))
                        )).toList();

    }
}
