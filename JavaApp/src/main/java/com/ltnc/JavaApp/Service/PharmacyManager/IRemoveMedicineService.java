package com.ltnc.JavaApp.Service.PharmacyManager;

import com.ltnc.JavaApp.Model.Medicine;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IRemoveMedicineService {
    public void removeMedicinesExpire(LocalDate date);
    public void removeFromMedicalBill(List<Map<String,Object>> presciption);
}
