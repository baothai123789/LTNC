package com.ltnc.JavaApp.Service;
import com.ltnc.JavaApp.Model.MedicalEquipment;
import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.MedicalEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalEquipmentService implements IInfomationService{
    private final MedicalEquipmentRepository medicalEquipmentRepository;

    @Autowired
    public MedicalEquipmentService(MedicalEquipmentRepository medicalEquipmentRepository) {
        this.medicalEquipmentRepository = medicalEquipmentRepository;
    }

    public List<MedicalEquipment> getAllMedicalEquipments() {
        return medicalEquipmentRepository.findAll();
    }

    public MedicalEquipment getMedicalEquipmentById(String id) {
        return medicalEquipmentRepository.findById(id).orElse(null);
    }

    public MedicalEquipment saveMedicalEquipment(MedicalEquipment equipment) {
        return medicalEquipmentRepository.save(equipment);
    }

    public void deleteMedicalEquipment(String id) {
        medicalEquipmentRepository.deleteById(id);
    }


    @Override
    public Optional<Person> getData(String id) {
        return Optional.empty();
    }
}
