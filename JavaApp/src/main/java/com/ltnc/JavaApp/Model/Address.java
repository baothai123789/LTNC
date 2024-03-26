package com.ltnc.JavaApp.Model;

public class Address {
   private final String nation;
   private final String province;
   private final String town;
   private final String street;
   
    public Address(String nation, String province, String town, String street) {
        this.nation = nation;
        this.province = province;
        this.town = town;
        this.street = street;
    }
}