package com.ltnc.JavaApp.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;



@Document("MedicalDetail")
public class MedicalDetail {
    @Id
    private String id;
    private String major;
    private String nameofDisease;
    private String PatientState;
    private boolean inProgress;
    private Prescription prescription;
    private MedicalSchedule medicalSchedule;

    public MedicalDetail() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


    public String getNameofDisease() {
        return nameofDisease;
    }

    public void setNameofDisease(String nameofDisease) {
        this.nameofDisease = nameofDisease;
    }


    public String getPatientState() {
        return PatientState;
    }

    public void setPatientState(String patientState) {
        PatientState = patientState;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public MedicalSchedule getMedicalSchedule() {
        return medicalSchedule;
    }

    public void setMedicalSchedule(MedicalSchedule medicalSchedule) {
        this.medicalSchedule = medicalSchedule;
    }

    @Override
    public String toString() {
        return "MedicalDetail{" +
                "id='" + id + '\'' +
                ", major='" + major + '\'' +
                ", nameofDisease='" + nameofDisease + '\'' +
                ", PatientState='" + PatientState + '\'' +
                ", inProgress=" + inProgress +
                ", prescription=" + prescription +
                ", medicalSchedule=" + medicalSchedule +
                '}';
    }
}
