package com.ltnc.JavaApp.Service.PharmacyService.Interface;

import com.ltnc.JavaApp.Model.PharmacyManager;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRemoveEquipmentService {
    public PharmacyManager removeEquipment(String pharmacyManagerId, String equipmentId);
}
