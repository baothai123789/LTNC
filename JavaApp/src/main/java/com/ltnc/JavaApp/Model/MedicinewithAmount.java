package com.ltnc.JavaApp.Model;

public class MedicinewithAmount {
    private String name;
    private Integer amount;

    public MedicinewithAmount(String name,Integer amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MedicinewithAmount{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
