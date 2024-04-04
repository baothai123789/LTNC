package com.ltnc.JavaApp.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class Certificate {
   private String department;
   private String major;

   private LocalDate time;

    public LocalDate getTime() {
        return time;
    }


    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Certificate(String department, String major, LocalDate time) {
        this.department = department;
        this.major = major;
        this.time = time;
    }

}
