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
public class FinancialEmployee extends Employee {
    @Id
    private String id;

    @DBRef
    private SalaryOfEmployee salary;

    @DBRef
    private TotalFund fund;

    @DBRef
    private FeeOfPatient fee;

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


}
