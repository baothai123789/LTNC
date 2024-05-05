package com.ltnc.JavaApp.Service.HospitalAdmission.DTO;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Service.MedicalDetailService.Service.MedicalDetailManageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;


@Component
public class HospitalAdmissionDTOMapper  {
    @Resource
    NurseMedicalDetailDTOMapper nurseMedicalDetailDTOMapper;
    @Resource
    MedicalDetailManageService medicalDetailManageService;

    public HospitalAdmissionDetailDTO map(HospitalAdmissionDetail hospitalAdmissionDetail, Patient patient, Doctor doctor) {
        return HospitalAdmissionDetailDTO.builder().id(hospitalAdmissionDetail.getId())
                .medicalDetail(nurseMedicalDetailDTOMapper.map(medicalDetailManageService.getMedicalDetail(hospitalAdmissionDetail.getMedicalDetailId())))
                .patientStates(hospitalAdmissionDetail.getPatientStates())
                .detail(hospitalAdmissionDetail.getDetail())
                .room(hospitalAdmissionDetail.getRoom())
                .startDate(hospitalAdmissionDetail.getStartDate())
                .endDate(hospitalAdmissionDetail.getEndDate())
                .done(hospitalAdmissionDetail.getDone())
                .prescription(hospitalAdmissionDetail.getPrescription())
                .patientInfo(new PatientInfoDTo(patient))
                .doctorInfo(new DoctorInfoDTO(doctor)).build();

    }
}
