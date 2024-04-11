package com.ltnc.JavaApp.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
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
    private List<Doctor> doctors = new ArrayList<>();
    @DBRef
    private List<Nurse> nurses = new ArrayList<>();
    @DBRef
    private List<Patient> patients = new ArrayList<>();
    @DBRef
    private List<SchedulePay> schedulePays = new ArrayList<>();

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

    public void addToFund(long fund) {
        this.fund.addFund(fund);
    }

    public void minustoFund(long fund){
        this.fund.minusFund(fund);
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

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    public void addNurse(Nurse nurse){
        nurses.add(nurse);
    }

    public void removeNurse(Nurse nurse){
        nurses.remove(nurse);
    }

    public void addPatient(Patient patient){
        patients.add(patient);
    }

    public void removePatient(Patient patient){
        patients.remove(patient);
    }
}
