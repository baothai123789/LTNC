package com.ltnc.JavaApp.Service.PharmacyManager;

import com.ltnc.JavaApp.Model.Medicine;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.MedicineRepository;
import com.ltnc.JavaApp.Repository.PharmacyManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddMedicineService implements IAddMedicineService {
    @Autowired
    MedicineRepository medicineRepository;


    @Override
    public void addMedicine(List<Medicine> medicineList) throws NullPointerException {
        medicineRepository.saveAll(medicineList);
    }
}
