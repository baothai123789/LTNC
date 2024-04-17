package com.ltnc.JavaApp.Service.PharmacyService.Interface;

import com.ltnc.JavaApp.Model.PharmacyEquipmentManager;

public interface IRemoveEquipmentService {
    public PharmacyEquipmentManager removeEquipment(String pharmacyManagerId, String equipmentId);
}
