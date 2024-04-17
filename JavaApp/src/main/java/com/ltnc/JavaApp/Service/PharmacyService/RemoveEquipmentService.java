package com.ltnc.JavaApp.Service.PharmacyService;

import com.ltnc.JavaApp.Model.MedicalEquipment;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.PharmacyManagerRepository;
import com.ltnc.JavaApp.Service.PharmacyService.Interface.IRemoveEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemoveEquipmentService implements IRemoveEquipmentService {

    @Autowired
    private PharmacyManagerRepository pharmacyManagerRepository;

    @Override
    public PharmacyManager removeEquipment(String pharmacyManagerId, String equipmentId) {
        Optional<PharmacyManager> pharmacyManagerOptional = pharmacyManagerRepository.findById(pharmacyManagerId);

        if (pharmacyManagerOptional.isPresent()) {
            PharmacyManager pharmacyManager = pharmacyManagerOptional.get();
            List<MedicalEquipment> currentEquipments = pharmacyManager.getMedicalEquipments();
            currentEquipments.removeIf(equipment -> equipment.getId().equals(equipmentId));
            pharmacyManager.setMedicalEquipments(currentEquipments);
            return pharmacyManagerRepository.save(pharmacyManager);
        } else {
            throw new RuntimeException("Pharmacy Manager not found with ID: " + pharmacyManagerId);
        }
    }
}
