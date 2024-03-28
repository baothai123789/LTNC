package com.ltnc.JavaApp.Service;

import com.ltnc.JavaApp.Model.Medicine;
import com.ltnc.JavaApp.Repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    @Autowired
    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public void addMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    public void removeMedicine(String medicineId) {
        medicineRepository.deleteById(medicineId);
    }

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Optional<Medicine> getMedicineById(String medicineId) {
        return medicineRepository.findById(medicineId);
    }
}
