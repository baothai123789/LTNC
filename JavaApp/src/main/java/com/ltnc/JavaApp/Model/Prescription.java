package com.ltnc.JavaApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    private List<MedicinewithAmount> medicines=new ArrayList<>();
    private String detail;
}

