package com.ltnc.JavaApp.Model;

import java.util.*;

public class Prescription {
    private String id;
    private List<MedicinewithAmount> medicines=new ArrayList<>();
    private String detail;

    public Prescription(String id, MedicinewithAmount medicine, String detail) {
        this.detail = detail;
        this.id=id;
        this.medicines.add(medicine);
    }

    public String getId() {
        return id;
    }
    public void addMedicine(MedicinewithAmount medicine){
        this.medicines.add(medicine);
    }
    public List<MedicinewithAmount> getMedicines(){
        return this.medicines;
    }

    public void setMedicines(List<MedicinewithAmount> medicines) {
        this.medicines = medicines;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id='" + id + '\'' +
                ", medicines=" + medicines +
                ", detail='" + detail + '\'' +
                '}';
    }
}
