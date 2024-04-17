package com.ltnc.JavaApp.ResponseModel.Pharmacy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicinePriceResponse {
   private List<Map<String,Object>> presciption;
   private Integer totalPrice;
}
