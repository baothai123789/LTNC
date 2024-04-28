package com.ltnc.JavaApp.Service.PharmacyService;

import com.ltnc.JavaApp.Model.MedicalEquipment;
import com.ltnc.JavaApp.Model.PharmacyEquipmentManager;
import com.ltnc.JavaApp.Repository.MedicalEquipmentRepository;
import com.ltnc.JavaApp.Repository.PharmacyManagerRepository;
import com.ltnc.JavaApp.Service.PharmacyService.Interface.IAddEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddEquipmentService implements IAddEquipmentService {

    @Autowired
    private PharmacyManagerRepository pharmacyManagerRepository;

    @Autowired
    private MedicalEquipmentRepository medicalEquipmentRepository;

    @Override
    public PharmacyEquipmentManager addEquipment(String id, MedicalEquipment equipment) {
        Optional<PharmacyEquipmentManager> pharmacyManagerOptional = pharmacyManagerRepository.findById(id);
        if (pharmacyManagerOptional.isPresent()) {
            PharmacyEquipmentManager pharmacyManager = pharmacyManagerOptional.get();
            List<MedicalEquipment> currentEquipments = pharmacyManager.getMedicalEquipments();
            currentEquipments.add(equipment);
            pharmacyManager.setMedicalEquipments(currentEquipments);

            return pharmacyManagerRepository.save(pharmacyManager);
        } else {
            throw new RuntimeException("No valid PharmacyManager found to add equipment");
        }
    }


}