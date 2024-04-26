package com.ltnc.JavaApp.Service.HospitalAdmission.DTO;

import com.ltnc.JavaApp.Model.MedicalRecord;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;



@Data
@Builder
public class NurseInfoDTO {
    private String id;
    private String phone;
    private String name;
    private Integer age;
    private String gender;
    private String position;

}
