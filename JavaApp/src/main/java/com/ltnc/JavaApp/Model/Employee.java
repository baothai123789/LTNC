package com.ltnc.JavaApp.Model;

import java.time.LocalDate;


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


    public Certificate getCertificate() {
        return this.certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public LocalDate getWorkFrom() {
        return this.workFrom;
    }

    public void setWorkFrom(LocalDate workFrom) {
        this.workFrom = workFrom;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
