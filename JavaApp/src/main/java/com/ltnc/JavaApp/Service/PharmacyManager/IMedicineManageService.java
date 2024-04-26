package com.ltnc.JavaApp.Service.PharmacyManager;

import com.ltnc.JavaApp.Model.Medicine;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IMedicineManageService{
    public void  addMedicines(List<Medicine> medicineList);
    public void removeMedicinesExpire();
    public List<Medicine> getMedicines();
    public Integer getMedicinesPrice(List<Map<String,Object>> presciption);
    public void removeMedicineFromPresciption(List<Map<String,Object>> prescription);
}
