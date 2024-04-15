package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Repository.MedicalBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddMedicalBillService implements IAddMedicalBill {
    @Autowired
    private MedicalBillRepository medicalBillRepository;
    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;


    private Optional<FinancialEmployee> findEmployee(){
        return financialEmployeeRepository.findFinancialEmployeeValid().orElseThrow(NullPointerException::new).stream().findFirst();
    }
    @Override
    public FinancialEmployee addMedicalBill(MedicalBill medicalBill) throws NullPointerException{
        List<Map<String,Object>> presciptions = medicalBill.getPrescription();
        int totalFee=0;
        for(Map<String,Object> preciption:presciptions){
            if((Boolean) preciption.get("inInventory")) {
                totalFee += ((Integer) preciption.get("price") * (Integer) preciption.get("amount"));
            }
        }
        medicalBill.setTotalPay(totalFee);
        MyApp.LOGGER.info("TotailFee"+medicalBill.getTotalPay());
        FinancialEmployee employee = findEmployee().orElseThrow(NullPointerException::new);
        MyApp.LOGGER.info(employee);
        employee.addMedicalBill(medicalBill);
        medicalBillRepository.save(medicalBill);
        financialEmployeeRepository.save(employee);
        return employee;
    }
}
