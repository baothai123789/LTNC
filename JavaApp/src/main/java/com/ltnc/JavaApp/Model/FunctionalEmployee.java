package com.ltnc.JavaApp.Model;

public class FunctionalEmployee extends  Employee{
    protected String part;

    public FunctionalEmployee(String part) {
        this.part = part;
    }

    public FunctionalEmployee() {
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }
}
