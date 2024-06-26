package com.ltnc.JavaApp.Service.HospitalAdmission.DTO;

import com.ltnc.JavaApp.Model.*;
import com.ltnc.JavaApp.Service.MedicalDetailService.DTO.IMedicalDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@Builder
public class HospitalAdmissionDetailDTO {
    NurseMedicalDetailDTOMapper nurseMedicalDetailDTOMapper;
    private String id;
    private IMedicalDetailDTO medicalDetail;
    private List<PatientState> patientStates=new ArrayList<>();
    private String detail;
    private LocalDate startDate;
    private LocalDate endDate;
    private Prescription prescription;
    private Boolean done;
    private String room;
    private PatientInfoDTo patientInfo;
    private DoctorInfoDTO doctorInfo;
}
