package com.ltnc.JavaApp.Model;

import java.time.LocalDate;



public class MedicalSchedule {
    private LocalDate time;
    private String detail;
    private boolean done;

    public MedicalSchedule(LocalDate time,String detail,boolean done) {
        this.time = time;
        this.detail=detail;
        this.done=done;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDate getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "MedicalSchedule{" +
                "time=" + time +
                ", detail='" + detail + '\'' +
                ", done=" + done +
                '}';
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }
}
