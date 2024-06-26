package com.ltnc.JavaApp.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("MedicalDetail")
public class MedicalDetail {
    @Id
    private String id;
    private String doctorId;
    private String patientId;
    private String major;
    private String nameofDisease;
    private String PatientState;
    private boolean inProgress;
    private Prescription prescription;
    private List<MedicalSchedule> medicalSchedules=new ArrayList<>();
    private LocalDate date;

}

