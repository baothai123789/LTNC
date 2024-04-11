package com.ltnc.JavaApp.Service.PharmacyService;

import com.ltnc.JavaApp.Model.MedicalEquipment;
import com.ltnc.JavaApp.Model.Medicine;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.PharmacyManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyManagerService {
    private final PharmacyManagerRepository pharmacyManagerRepository;

    @Autowired
    public PharmacyManagerService(PharmacyManagerRepository pharmacyManagerRepository) {
        this.pharmacyManagerRepository = pharmacyManagerRepository;
    }

    public void addMedicine(String managerId, Medicine medicine) {
        PharmacyManager pharmacyManager = getPharmacyManagerById(managerId);
        if (pharmacyManager != null) {
            pharmacyManager.getMedicines().add(medicine);
            pharmacyManagerRepository.save(pharmacyManager);
        }
    }

    public void removeMedicine(String managerId, String medicineId) {
        PharmacyManager pharmacyManager = getPharmacyManagerById(managerId);
        if (pharmacyManager != null) {
            List<Medicine> medicines = pharmacyManager.getMedicines();
            medicines.removeIf(m -> m.getId().equals(medicineId));
            pharmacyManagerRepository.save(pharmacyManager);
        }
    }

    public List<Medicine> getAllMedicines(String managerId) {
        PharmacyManager pharmacyManager = getPharmacyManagerById(managerId);
        return pharmacyManager != null ? pharmacyManager.getMedicines() : null;
    }

    public void addMedicalEquipment(String managerId, MedicalEquipment equipment) {
        PharmacyManager pharmacyManager = getPharmacyManagerById(managerId);
        if (pharmacyManager != null) {
            pharmacyManager.getMedicalEquipments().add(equipment);
            pharmacyManagerRepository.save(pharmacyManager);
        }
    }

    public void removeMedicalEquipment(String managerId, String equipmentId) {
        PharmacyManager pharmacyManager = getPharmacyManagerById(managerId);
        if (pharmacyManager != null) {
            List<MedicalEquipment> medicalEquipments = pharmacyManager.getMedicalEquipments();
            medicalEquipments.removeIf(e -> e.getId().equals(equipmentId));
            pharmacyManagerRepository.save(pharmacyManager);
        }
    }

    public List<MedicalEquipment> getAllMedicalEquipments(String managerId) {
        PharmacyManager pharmacyManager = getPharmacyManagerById(managerId);
        return pharmacyManager != null ? pharmacyManager.getMedicalEquipments() : null;
    }

    private PharmacyManager getPharmacyManagerById(String managerId) {
        return pharmacyManagerRepository.findById(managerId).orElse(null);
    }
}
