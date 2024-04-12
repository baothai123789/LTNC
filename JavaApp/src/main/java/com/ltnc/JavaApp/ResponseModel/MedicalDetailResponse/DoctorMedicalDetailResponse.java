package com.ltnc.JavaApp.ResponseModel.MedicalDetailResponse;

import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.MedicalSchedule;
import com.ltnc.JavaApp.Model.Prescription;
import lombok.Data;

import java.util.List;

@Data
public class DoctorMedicalDetailResponse {
    private String id;
    private String patientId;
    private String major;
    private String nameofDisease;
    private String PatientState;
    private boolean inProgress;
    private Prescription prescription;
    private List<MedicalSchedule> medicalSchedules;
    public DoctorMedicalDetailResponse(MedicalDetail medicalDetail){
        this.id = medicalDetail.getId();
        this.patientId = medicalDetail.getPatientId();
        this.major = medicalDetail.getMajor();
        this.nameofDisease = medicalDetail.getNameofDisease();
        this.PatientState = medicalDetail.getPatientState();
        this.inProgress = medicalDetail.isInProgress();
        this.medicalSchedules = medicalDetail.getMedicalSchedules().stream().toList();
        this.prescription = medicalDetail.getPrescription();
    }
}
