package com.ltnc.JavaApp.Model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "role")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Doctor.class, name = "doctor"),
        @JsonSubTypes.Type(value = Nurse.class, name = "nurse"),
        @JsonSubTypes.Type(value = FinancialEmployee.class,name="financialemployee"),
        @JsonSubTypes.Type(value = PharmacyEquipmentManager.class,name="pharmacymanager")
})
public abstract class Employee extends Person {
   protected List<Certificate> certificate;
   protected LocalDate workFrom;
   protected String position;
   public abstract String getPart();
   public abstract String getMajor();
   public abstract void setMajor(String major);
   public abstract void setUserAccount(UserAccount userAccount);
}

