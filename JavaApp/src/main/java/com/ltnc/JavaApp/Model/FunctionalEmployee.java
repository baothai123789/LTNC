package com.ltnc.JavaApp.Model;

public class FunctionalEmployee extends  Employee{
    protected String part;

    public FunctionalEmployee(String part) {
        this.part = part;
    }

    public FunctionalEmployee() {
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }
}
