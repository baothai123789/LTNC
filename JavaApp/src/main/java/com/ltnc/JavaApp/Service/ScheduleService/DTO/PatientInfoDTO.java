package com.ltnc.JavaApp.Service.ScheduleService.DTO;

import com.ltnc.JavaApp.Model.Certificate;
import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalRecord;
import com.ltnc.JavaApp.Model.Patient;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PatientInfoDTO{
    private String id;
    private String name;
    private String phone;
    private String gender;
    private int age;
    private List<MedicalRecord> medicalRecords;
    public PatientInfoDTO(Patient patient){
        this.id= patient.getId();
        this.age = patient.getAge();
        this.name = patient.getName();
        this.gender = patient.getGender();
        this.medicalRecords = patient.getMedicalRecords();
        this.phone = patient.getPhone();
    }
}
