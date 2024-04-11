package com.ltnc.JavaApp.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "FinancialEmployee")
public class FinancialEmployee extends FunctionalEmployee {
    @Id
    private String id;
    private int salary;
    private TotalFund fund;

    @DBRef
    private List<Doctor> doctors;
    @DBRef
    private List<Nurse> nurses;
    @DBRef
    private List<Patient> patients;
    @DBRef
    private List<SchedulePay> schedulePays;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getRole(){
        return "FinancialEmployee";
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<SchedulePay> getSchedulePays() {
        return schedulePays;
    }

    public void setSchedulePays(List<SchedulePay> schedulePays) {
        this.schedulePays = schedulePays;
    }

    public long getFund() {
        return fund.getFund();
    }

    public void setFund(long fund) {
        this.fund.setFund(fund);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
