package com.ltnc.JavaApp.RequestModel.MedicalDetail;

public class MedicalDetailInfo {
    private String patientId;
    private String doctorId;

    public MedicalDetailInfo(String patientId, String doctorId) {
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public MedicalDetailInfo() {
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
