package com.ltnc.JavaApp.Service.PharmacyManager;

import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.RequestModel.MedicinRequestModel.MedicinCreateRequestModel;
import com.ltnc.JavaApp.Service.FinancialService.CreateMedicalBillAdapter;
import com.ltnc.JavaApp.Service.ProfileService.Patient.PatientProfileManageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class CreatePresciptionService {
    @Resource
    MedicineManageService medicineManageService;
    @Resource
    PatientProfileManageService patientProfileManageService;
    @Resource
    CreateMedicalBillAdapter createMedicalBillAdapter;
    public void createNewPresciption(MedicinCreateRequestModel medicinCreateRequestModel){
        Patient patient = patientProfileManageService.getProfile(medicinCreateRequestModel.getPatientId());
        medicineManageService.removeMedicineFromPresciption(medicinCreateRequestModel.getPresciption());
        Map<String,Object> dataforMedicalBill = new HashMap<>(Map.of(
                "type","medicinebill",
                "medicine",medicinCreateRequestModel.getPresciption()
        ));
        createMedicalBillAdapter.createMedicalBill(dataforMedicalBill,patient);

    }
}
