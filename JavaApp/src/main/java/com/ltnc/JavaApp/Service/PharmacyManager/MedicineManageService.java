package com.ltnc.JavaApp.Service.PharmacyManager;

import com.ltnc.JavaApp.Model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class MedicineManageService implements IMedicineManageService{

    @Autowired
    IAddMedicineService addMedicineService;
    @Autowired
    IRemoveMedicineService removeMedicineService;
    @Autowired
    IGetMedicines getMedicines;
    @Override
    public void addMedicines(List<Medicine> medicineList) {
        this.addMedicineService.addMedicine(medicineList);
    }

    @Override
    public void removeMedicinesExpire() {
        this.removeMedicineService.removeMedicinesExpire(LocalDate.now());
    }

    @Override
    public List<Medicine> getMedicines() {
        return this.getMedicines.getMedicines();
    }

    @Override
    public Integer getMedicinesPrice(List<Map<String, Object>> presciption) {
        return getMedicines.getMedicinePrice(presciption);
    }

    @Override
    public void removeMedicineFromPresciption(List<Map<String, Object>> prescription) {
        this.removeMedicineService.removeFromMedicalBill(prescription);
    }

}
