package com.ltnc.JavaApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Address {
   private final String nation;
   private final String province;
   private final String town;
   private final String street;
}