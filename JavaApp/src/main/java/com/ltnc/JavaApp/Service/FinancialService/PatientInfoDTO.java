package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.Address;
import com.ltnc.JavaApp.Model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientInfoDTO {
    private String id;
    private String name;
    private String phone;
    private String gender;
    private int age;
    private Address address;
    public PatientInfoDTO(Patient patient){
        this.id = patient.getId();
        this.name = patient.getName();
        this.phone = patient.getPhone();
        this.gender = patient.getGender();
        this.age = patient.getAge();
        this.address = patient.getAddress();
    }
}
