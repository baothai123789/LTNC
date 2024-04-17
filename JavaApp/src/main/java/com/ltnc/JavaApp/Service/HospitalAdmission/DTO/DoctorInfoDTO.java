package com.ltnc.JavaApp.Service.HospitalAdmission.DTO;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.MedicalRecord;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DoctorInfoDTO {
    private String id;
    private String phone;
    private String name;
    private Integer age;
    private String gender;
    private String major;
    private String position;
    public DoctorInfoDTO(Doctor doctor){
        this.id = doctor.getId();
        this.name = doctor.getName();
        this.phone = doctor.getPhone();
        this.age =doctor.getAge();
        this.gender = doctor.getGender();
        this.major = doctor.getMajor();
        this.position = doctor.getPosition();
    }
}
