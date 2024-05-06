package com.ltnc.JavaApp.ResponseModel.ProfileResponse;

import com.ltnc.JavaApp.Model.Address;
import com.ltnc.JavaApp.Model.Certificate;
import com.ltnc.JavaApp.Model.Employee;
import java.util.List;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeProfileResponseModel {
    private String id;
    private String name;
    private String phone;
    private String gender;
    private int age;
    private Address address;
    private LocalDate workFrom;
    private String role;
    private String part;
    private String position;
    private List<Certificate> certificateList;
    private String major;

    public EmployeeProfileResponseModel(Employee patient){
        this.id = patient.getId();
        this.name = patient.getName();
        this.phone = patient.getPhone();
        this.gender = patient.getGender();
        this.age = patient.getAge();
        this.address = new Address(patient.getAddress().getNation(),patient.getAddress().getProvince(),patient.getAddress().getTown(),patient.getAddress().getStreet());
        this.workFrom = patient.getWorkFrom();
        this.role = patient.getRole();
        this.part = patient.getPart();
        this.position=patient.getPosition();
        this.certificateList = patient.getCertificate().stream().toList();
        this.major = patient.getMajor();

    }
}
