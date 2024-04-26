package com.ltnc.JavaApp.Service.PharmacyService.Interface;

import com.ltnc.JavaApp.Model.MedicalEquipment;
import com.ltnc.JavaApp.Model.PharmacyEquipmentManager;

public interface IAddEquipmentService {
    public PharmacyEquipmentManager addEquipment(String id, MedicalEquipment equipment);
}
