package com.ltnc.JavaApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("Medicine")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {
    @Id
    private String id;
    private String name;
    private String type;
    private LocalDate arrivalDate;
    private LocalDate expireDay;
    private Integer amount;
    private String unit;
    private Integer pricePerUnit;
}
