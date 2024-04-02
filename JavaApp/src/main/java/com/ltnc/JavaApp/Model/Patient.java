package com.ltnc.JavaApp.Model;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Patient")
public class Patient extends Person {
    @Id
    private String id;
    private List<MedicalRecord> medicalrecord;

    public Patient() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MedicalRecord> getMedicalrecord() {
        return this.medicalrecord;
    }

    public void setMedicalrecord(List<MedicalRecord> medicalrecord) {
        this.medicalrecord = medicalrecord;
    }
}
