package com.ltnc.JavaApp.Service.PharmacyService.Interface;

import com.ltnc.JavaApp.Model.MedicalEquipment;
import com.ltnc.JavaApp.Model.PharmacyManager;

public interface IAddEquipmentService {
    public PharmacyManager addEquipment(String id,MedicalEquipment equipment);
}
