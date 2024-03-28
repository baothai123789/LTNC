package com.ltnc.JavaApp.Service;

import com.ltnc.JavaApp.Model.Person;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Repository.PharmacyManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PharmacyManagerService  {
    private final PharmacyManagerRepository pharmacyManagerRepository;

    @Autowired
    public PharmacyManagerService(PharmacyManagerRepository pharmacyManagerRepository) {
        this.pharmacyManagerRepository = pharmacyManagerRepository;
    }

    public List<PharmacyManager> getAllPharmacyManagers() {
        return pharmacyManagerRepository.findAll();
    }

    public PharmacyManager getPharmacyManagerById(String id) {
        return pharmacyManagerRepository.findById(id).orElse(null);
    }

    public PharmacyManager savePharmacyManager(PharmacyManager pharmacyManager) {
        return pharmacyManagerRepository.save(pharmacyManager);
    }

    public void deletePharmacyManager(String id) {
        pharmacyManagerRepository.deleteById(id);
    }



    public Optional<PharmacyManager> getData(String id) {
        return pharmacyManagerRepository.findById(id);
    }
}
