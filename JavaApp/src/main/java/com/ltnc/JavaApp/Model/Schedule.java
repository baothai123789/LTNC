package com.ltnc.JavaApp.Model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Schedule")
public class Schedule {
    @Id
    private String id;
    @Indexed
    private LocalDate date;
    private Integer time;
    @DBRef
    private String patientd;
    @DBRef
    private String doctorid;
    private String detail;
    public Schedule(String id, LocalDate date, Integer time, String patient, String doctor, String detail) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.patientd = patient;
        this.doctorid = doctor;
        this.detail = detail;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Integer getTime() {
        return time;
    }
    public Schedule() {
    }
    public void setTime(Integer time) {
        this.time = time;
    }
    public String getPatient() {
        return patientd;
    }
    public void setPatient(String patient) {
        this.patientd = patient;
    }
    public String getDoctor() {
        return doctorid;
    }
    public void setDoctor(String doctor) {
        this.doctorid = doctor;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
