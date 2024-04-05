package com.ltnc.JavaApp.Model;

import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("Medicine")
public class Medicine {
    @Id
    private String id;
    private String name;
    private String type;
    private LocalDate arrivaldate;
    private LocalDate expireday;

    public Medicine(String id,String name,String type,String arrivaldate,String expiredate) {
        this.id=id;
        this.name=name;
        this.type=type;
        this.arrivaldate=LocalDate.parse(arrivaldate);
        this.expireday=LocalDate.parse(expiredate);
    }

    public LocalDate getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(String arrivaldate) {
        this.arrivaldate = LocalDate.parse(arrivaldate);
    }

    public LocalDate getExpireday() {
        return expireday;
    }

    public void setExpireday(String expireday) {
        this.expireday = LocalDate.parse(expireday);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", arrivaldate=" + arrivaldate +
                ", expireday=" + expireday +
                '}';
    }
}
