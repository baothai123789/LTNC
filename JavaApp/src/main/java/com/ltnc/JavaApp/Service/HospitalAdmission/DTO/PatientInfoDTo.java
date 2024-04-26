package com.ltnc.JavaApp.Service.HospitalAdmission.DTO;

import com.ltnc.JavaApp.Model.MedicalRecord;
import com.ltnc.JavaApp.Model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

public class PatientInfoDTo {
    private String id;
    private String phone;
    private List<MedicalRecord> medicalRecords;
    private String name;
    private Integer age;
    private String gender;
    public PatientInfoDTo(Patient patient){
        this.id = patient.getId();
        this.name = patient.getName();
        this.medicalRecords = patient.getMedicalRecords();
        this.age = patient.getAge();
        this.gender = patient.getGender();
        this.phone = patient.getPhone();
    }
}
