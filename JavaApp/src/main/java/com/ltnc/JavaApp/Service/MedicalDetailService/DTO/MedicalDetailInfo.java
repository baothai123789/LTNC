package com.ltnc.JavaApp.Service.MedicalDetailService.DTO;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class MedicalDetailInfo {
    private Patient patient;
    private Doctor doctor;
}
