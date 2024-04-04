package com.ltnc.JavaApp.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "role")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Doctor.class, name = "doctor"),
        @JsonSubTypes.Type(value = Nurse.class, name = "nurse")
})
public abstract class Employee extends Person {
   protected String role;
   protected Certificate certificate;
   protected LocalDate workFrom;
   protected String position;

    public Employee() {
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setWorkFrom(LocalDate workFrom) {
        this.workFrom = workFrom;
    }

    public Certificate getCertificate() {
        return this.certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public LocalDate getWorkFrom() {
        return this.workFrom;
    }

    public void setWorkFrom(String workFrom) {
        this.workFrom = LocalDate.parse(workFrom);
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
