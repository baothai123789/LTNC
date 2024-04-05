package com.ltnc.JavaApp.Model;

import java.time.LocalDate;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Schedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    private String id;
    @Indexed
    private LocalDate date;
    private Integer time;
    @DBRef
    private Patient patient;
    @DBRef
    private Doctor doctor;
    private String detail;
}