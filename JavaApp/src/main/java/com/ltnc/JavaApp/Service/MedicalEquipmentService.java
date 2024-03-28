package com.ltnc.JavaApp.Service;

import com.ltnc.JavaApp.Model.MedicalEquipment;
import com.ltnc.JavaApp.Repository.MedicalEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalEquipmentService {

    private final MedicalEquipmentRepository medicalEquipmentRepository;

    @Autowired
    public MedicalEquipmentService(MedicalEquipmentRepository medicalEquipmentRepository) {
        this.medicalEquipmentRepository = medicalEquipmentRepository;
    }

    public void addMedicalEquipment(MedicalEquipment equipment) {
        medicalEquipmentRepository.save(equipment);
    }

    public void removeMedicalEquipment(String equipmentId) {
        medicalEquipmentRepository.deleteById(equipmentId);
    }

    public List<MedicalEquipment> getAllMedicalEquipments() {
        return medicalEquipmentRepository.findAll();
    }

    public Optional<MedicalEquipment> getMedicalEquipmentById(String equipmentId) {
        return medicalEquipmentRepository.findById(equipmentId);
    }
}
