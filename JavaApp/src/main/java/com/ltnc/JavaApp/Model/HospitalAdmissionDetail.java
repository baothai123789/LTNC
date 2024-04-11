package com.ltnc.JavaApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "HospitalAdmissionDetail")
public class HospitalAdmissionDetail {
    @Id
    private String id;
    @DBRef
    private MedicalDetail medicalDetail;
    @DBRef
    private Doctor doctor;
    @DBRef
    private Patient patient;
    private List<PatientState> patientStates=new ArrayList<>();
    private String detail;
    private LocalDate startDate;
    private LocalDate endDate;
    private Prescription prescription;
    private Boolean done;
    private String room;

    public void addPatientState(PatientState newPatientState){
        this.patientStates.add(newPatientState);
    }
}
