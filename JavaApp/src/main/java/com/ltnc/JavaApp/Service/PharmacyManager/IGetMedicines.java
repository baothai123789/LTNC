package com.ltnc.JavaApp.Service.PharmacyManager;

import com.ltnc.JavaApp.Model.Medicine;

import java.util.List;
import java.util.Map;

public interface IGetMedicines {
    public List<Medicine> getMedicines();
    public Integer getMedicinePrice(List<Map<String,Object>> presciption);
}
