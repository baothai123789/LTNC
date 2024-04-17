package com.ltnc.JavaApp.Service.PharmacyManager;

import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.RequestModel.MedicinRequestModel.MedicinCreateRequestModel;
import com.ltnc.JavaApp.Service.FinancialService.CreateNewMedicalBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CreatePresciptionService {
    @Autowired
    MedicineManageService medicineManageService;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    CreateNewMedicalBillService createNewMedicalBillService;
    public void createNewPresciption(MedicinCreateRequestModel medicinCreateRequestModel){
        Patient patient = patientRepository.findById(medicinCreateRequestModel.getPatientId()).orElseThrow(()->new NullPointerException("pateint not found"));
        medicineManageService.removeMedicineFromPresciption(medicinCreateRequestModel.getPresciption());
        createNewMedicalBillService.createNewMedicalBill(
                null,medicinCreateRequestModel.getPresciption(),patient,"medicinebill"
        );
    }
}
