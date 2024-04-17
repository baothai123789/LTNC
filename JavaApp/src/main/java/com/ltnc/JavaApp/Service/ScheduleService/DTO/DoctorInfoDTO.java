package com.ltnc.JavaApp.Service.ScheduleService.DTO;

import com.ltnc.JavaApp.Model.Certificate;
import com.ltnc.JavaApp.Model.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DoctorInfoDTO {
    private String id;
    private String name;
    private String phone;
    private String gender;
    private int age;
    private String major;
    private List<Certificate> certificate;
    private String position;
    public DoctorInfoDTO(Doctor doctor){
        this.id= doctor.getId();
        this.position= doctor.getPosition();
        this.age = doctor.getAge();
        this.name = doctor.getName();
        this.gender = doctor.getGender();
        this.major = doctor.getMajor();
        this.certificate = doctor.getCertificate();
        this.phone = doctor.getPhone();
    }
}
