package com.ltnc.JavaApp.RequestModel.MedicinRequestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicinCreateRequestModel {
    private String patientId;
    private List<Map<String,Object>> presciption;
    private Integer totalPay;
}
