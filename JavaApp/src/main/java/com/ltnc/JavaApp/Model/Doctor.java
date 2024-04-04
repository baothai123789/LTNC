package com.ltnc.JavaApp.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "Doctor")
public class Doctor extends Employee {
    @Id
    private String id;
    private String major;
    @DBRef
    private List<MedicalDetail> medicalDetails=new ArrayList<>();

    public Doctor() {
    }
    public Doctor(String id){
        this.role="doctor";
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    @Override
    public void setRole(String role){
    }

    public List<MedicalDetail> getMedicalDetails() {
        return medicalDetails;
    }
    public void addMedicalDetail(MedicalDetail newdetail){
        this.medicalDetails.add(newdetail);
    }

    public String getRole(){
        return "doctor";
    }
}