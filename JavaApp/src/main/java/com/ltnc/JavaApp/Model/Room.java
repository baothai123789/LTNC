package com.ltnc.JavaApp.Model;

import java.util.List;
import org.springframework.data.annotation.Id;

public class Room {
    @Id
    private String id;
    private int capacity;
    private String ServiceType;
    private List<Patient> patientList;

    public Room(String id, int capacity, String serviceType, List<Patient> patientList) {
        this.id = id;
        this.capacity = capacity;
        ServiceType = serviceType;
        this.patientList = patientList;
    }

    public Room(String id, int capacity, String serviceType) {
        this.id = id;
        this.capacity = capacity;
        ServiceType = serviceType;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public void addPatient(Patient patient) {
        if (patientList.size() < capacity) {
            patientList.add(patient);
            System.out.println("Patient " + patient.getName() + " added to the room.");
        } else {
            System.out.println("Room is full. Cannot add more patients.");
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Room ID: ").append(this.id).append("\n");
        sb.append("Capacity: ").append(this.capacity).append("\n");
        sb.append("Service Type: ").append(this.ServiceType).append("\n");
        sb.append("Patients:\n");
        for (Patient patient : patientList) {
            sb.append("  Name: ").append(patient.getName()).append("\n");
            sb.append("  Age: ").append(patient.getAge()).append("\n");
            sb.append("  Gender: ").append(patient.getGender()).append("\n");
        }
        return sb.toString();
    }
}
