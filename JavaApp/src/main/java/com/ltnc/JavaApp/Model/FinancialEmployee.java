package com.ltnc.JavaApp.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FinancialEmployee")
public class FinancialEmployee extends FunctionalEmployee {
    @Id
    private String id;

    public FinancialEmployee() {
        this.role = "FinancialEmployee";
        this.part = "Financial";
    }

}
