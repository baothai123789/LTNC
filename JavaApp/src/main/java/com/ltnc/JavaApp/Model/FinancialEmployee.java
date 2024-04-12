package com.ltnc.JavaApp.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "FinancialEmployee")
public class FinancialEmployee extends Employee {
    @Id
    private String id;

    @DBRef
    private Map<Doctor,Integer> doctorIntegerMap = new HashMap<>();

    @DBRef
    private Map<Nurse,Integer> nurseIntegerMap = new HashMap<>();

    @DBRef
    private Map<PharmacyManager, Integer> pharmacyManagerIntegerMap = new HashMap<>();

    @DBRef
    private Map<Patient,Integer> patientIntegerMap = new HashMap<>();

    @DBRef
    private TotalFund fund;

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


    public long getFund() {
        return fund.getFund();
    }

    public void addToFund(long fund) {
        this.fund.addFund(fund);
    }

    public void minusToFund(long fund){
        this.fund.minusFund(fund);
    }

    public void addToDoctorMap(Doctor doctor) {
        doctorIntegerMap.put(doctor, 0);
    }

    public void addToNurseMap(Nurse nurse) {
        nurseIntegerMap.put(nurse, 0);
    }

    public void addToPharmacyManagerMap(PharmacyManager pharmacyManager) {
        pharmacyManagerIntegerMap.put(pharmacyManager, 0);
    }

    public void addToPatientMap(Patient patient) {
        patientIntegerMap.put(patient, 0);
    }


    public void setDoctorSalary(Doctor doctor, int salary) {
        if (doctorIntegerMap.containsKey(doctor)) {
            doctorIntegerMap.put(doctor, salary);
        }
    }

    public void setNurseSalary(Nurse nurse, int salary) {
        if (nurseIntegerMap.containsKey(nurse)) {
            nurseIntegerMap.put(nurse, salary);
        }
    }

    public void setPharmacyManagerSalary(PharmacyManager pharmacyManager, int salary) {
        if (pharmacyManagerIntegerMap.containsKey(pharmacyManager)) {
            pharmacyManagerIntegerMap.put(pharmacyManager, salary);
        }
    }

    public void setPatientFee(Patient patient, int fee) {
        if (patientIntegerMap.containsKey(patient)) {
            patientIntegerMap.put(patient, fee);
        }
    }

    public int getDoctorSalary(Doctor doctor) {
        if(doctorIntegerMap.containsKey(doctor))
            return this.doctorIntegerMap.getOrDefault(doctor, 0);
        return -1;
    }

    public int getNurseSalary(Nurse nurse) {
        if(nurseIntegerMap.containsKey(nurse))
            return this.nurseIntegerMap.getOrDefault(nurse, 0);
        return -1;
    }

    public int getPharmacyManagerSalary(PharmacyManager pharmacyManager) {
        if (pharmacyManagerIntegerMap.containsKey(pharmacyManager)) {
            return pharmacyManagerIntegerMap.getOrDefault(pharmacyManager, 0);
        }
        return -1;
    }

    public int getPatientFee(Patient patient) {
        if (patientIntegerMap.containsKey(patient)) {
            return patientIntegerMap.getOrDefault(patient, 0);
        }
        return -1;
    }

}
