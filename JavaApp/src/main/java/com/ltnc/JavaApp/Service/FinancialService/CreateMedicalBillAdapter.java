package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.MyApp;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CreateMedicalBillAdapter implements ICreateMedicalBillAdapter{
    @Resource
    CreateNewMedicalBillService createNewMedicalBillService;
    @Resource
    MedicalBillCreatorFactory medicalBillCreatorFactory;
    private boolean validateData(Map<String,Object> data){
        if(!data.containsKey("type")) return false;
        if(((String)data.get("type")).equalsIgnoreCase("medicaldetailbill")){
            return data.containsKey("medicalDetail");
        }
        else if (((String)data.get("type")).equalsIgnoreCase("medicinebill")){
            if(!data.containsKey("medicine")) return false;
            return List.class.isInstance(data.get("medicine").getClass());
        }
        else return false;

    }
    MedicalBill convertToMedicalBill(Map<String,Object> data, Patient patient){
        IMedicalBillCreator medicalBillCreator = medicalBillCreatorFactory.getBillCreator((String) data.get("type"));
        return medicalBillCreator.createBill(data,patient);

    }
    @Override
    public void createMedicalBill(Map<String, Object> data,Patient patient) {
        MyApp.LOGGER.info(data.get("type"));
        if(!validateData(data)) throw new RuntimeException("wrong data for medical Bill");
        MedicalBill medicalBill = convertToMedicalBill(data,patient);
        createNewMedicalBillService.createNewMedicalBill(medicalBill,patient);
    }
}
