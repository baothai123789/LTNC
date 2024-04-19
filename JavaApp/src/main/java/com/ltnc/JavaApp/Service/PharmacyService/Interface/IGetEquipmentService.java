package com.ltnc.JavaApp.Service.PharmacyService.Interface;

import com.ltnc.JavaApp.Model.MedicalEquipment;

import java.util.List;

public interface IGetEquipmentService {
    public MedicalEquipment getMedicalEquipmentById(String managerId, String equipmentId);
    public List<MedicalEquipment> getAllMedicalEquipments(String managerId);
}
