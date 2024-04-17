package com.ltnc.JavaApp.Model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "part")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FinancialEmployee.class, name = "financialEmployee"),
        @JsonSubTypes.Type(value = PharmacyEquipmentManager.class, name = "pharmacyManager")
})
public abstract class FunctionalEmployee extends  Employee{
    @Override
    public String getRole() {
        return "functionalEmployee";
    }
}
