package com.ltnc.JavaApp.Model;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Patient")
public class Patient extends Person {
    @Id
    private String id;
    private List<MedicalRecord> medicalrecord=new ArrayList<>();

    @DBRef
    List<MedicalDetail> medicalDetails=new ArrayList<>();
    public Patient() {}
    public Patient(String id){}

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MedicalRecord> getMedicalrecord() {
        return this.medicalrecord;
    }

    public List<MedicalDetail> getMedicalDetails() {
        return medicalDetails;
    }
    public void addMedicalDetail(MedicalDetail newdetail){
        this.medicalDetails.add(newdetail);
    }
}
