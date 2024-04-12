package com.ltnc.JavaApp.ResponseModel.ProfileResponse;

import com.ltnc.JavaApp.Model.Address;
import com.ltnc.JavaApp.Model.Patient;
import lombok.Data;

@Data
public class PatientProfileResponseModel {
    private String id;
    private String name;
    private String phone;
    private String gender;
    private int age;
    private Address address;
    public PatientProfileResponseModel(Patient patient){
        this.id = patient.getId();
        this.name = patient.getName();
        this.phone = patient.getPhone();
        this.gender = patient.getPhone();
        this.age = patient.getAge();
        this.address = new Address(patient.getAddress().getNation(),patient.getAddress().getProvince(),patient.getAddress().getTown(),patient.getAddress().getStreet());
    }
}
