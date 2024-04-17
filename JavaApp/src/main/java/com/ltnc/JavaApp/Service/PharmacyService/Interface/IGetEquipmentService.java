package com.ltnc.JavaApp.Service.PharmacyService.Interface;

import com.ltnc.JavaApp.Model.MedicalEquipment;
import com.ltnc.JavaApp.Model.PharmacyManager;

import java.util.List;
import java.util.Optional;

public interface IGetEquipmentService {
    public MedicalEquipment getMedicalEquipmentById(String id);
    public List<MedicalEquipment> getAllMedicalEquipments();
}
