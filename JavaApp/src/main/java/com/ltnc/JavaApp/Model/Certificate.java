package com.ltnc.JavaApp.Model;

import java.time.LocalDate;

public class Certificate {
   private String department;
   private String major;
   private LocalDate time;


    public Certificate(String department, String major, LocalDate time) {
        this.department = department;
        this.major = major;
        this.time = time;
    }

}
