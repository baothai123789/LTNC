package com.ltnc.JavaApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {

    protected String name;
    protected String phone;
    protected String gender;
    protected int age;
    protected Address address;

    public abstract String getId();

    public abstract void setId(String id);
}
