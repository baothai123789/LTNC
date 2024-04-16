package com.ltnc.JavaApp.Service;

import com.ltnc.JavaApp.Model.Medicine;

import java.time.LocalDate;
import java.util.List;

public interface IMedicineManageService{
    public void addMedicines(String userId, List<Medicine> medicineList);
    public void removeMedicines(String userId, LocalDate date);
    public List<Medicine> getMedicines(String userId,LocalDate date);
}
