package com.ltnc.JavaApp.Service.PharmacyService;

import com.ltnc.JavaApp.Model.MedicalEquipment;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.MedicalEquipmentRepository;
import com.ltnc.JavaApp.Repository.PharmacyManagerRepository;
import com.ltnc.JavaApp.Service.PharmacyService.Interface.IGetEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetEquipmentService implements IGetEquipmentService {

    @Autowired
    private PharmacyManagerRepository pharmacyManagerRepository;

    @Autowired
    private MedicalEquipmentRepository medicalEquipmentRepository;

    @Override
    public MedicalEquipment getMedicalEquipmentById(String id) {
        Optional<MedicalEquipment> medicalEquipmentOptional = medicalEquipmentRepository.findById(id);
        return medicalEquipmentOptional.orElse(null);
    }

    @Override
    public List<MedicalEquipment> getAllMedicalEquipments() {
        return medicalEquipmentRepository.findAll();
    }
}
