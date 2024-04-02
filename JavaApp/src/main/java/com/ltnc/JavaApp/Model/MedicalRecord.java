package com.ltnc.JavaApp.Model;

import java.time.LocalDate;


public class MedicalRecord {
   private String name;
   private LocalDate time;
   private boolean treatment;

    public MedicalRecord(String name, LocalDate time, boolean treatment) {
        this.name = name;
        this.time = time;
        this.treatment = treatment;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getTime() {
        return this.time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public boolean isTreatment() {
        return this.treatment;
    }

    public boolean getTreatment() {
        return this.treatment;
    }

    public void setTreatment(boolean treatment) {
        this.treatment = treatment;
    }

}
