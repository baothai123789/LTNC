package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.*;
import com.mongodb.lang.Nullable;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service
public class CreateNewMedicalBillService {
    @Autowired
    MedicalBillCreatorFactory medicalBillCreatorFactory;
    @Autowired
    FinancialNotifyService financialNotifyService;
    @Autowired
    FindFinancialEmployeeService findFinancialEmployeeService;
    @Autowired
    IAddMedicalBill addMedicalBill;

    public void createNewMedicalBill(@Nullable MedicalDetail medicalDetail,
                                     @Nullable List<Map<String,Object>> presciption,
                                     @Nonnull Patient patient,@Nonnull String type) throws NullPointerException{
        IMedicalBillCreator creator = medicalBillCreatorFactory.getBillCreator(type);
        MedicalBill medicalBill=creator.createBill(medicalDetail,presciption,patient);
        FinancialEmployee financialEmployee = findFinancialEmployeeService.findEmployee().orElseThrow(()->new NullPointerException("cannot find financial employee"));
        financialEmployee.addMedicalBill(medicalBill);
        addMedicalBill.addMedicalBill(medicalBill,financialEmployee);
        financialNotifyService.sendNotifytoEmployee(financialEmployee,medicalBill,patient.getId());
        financialNotifyService.sendNotifytoPatient(patient,medicalBill,financialEmployee.getPhone(), medicalBill.getId());
    }
}
