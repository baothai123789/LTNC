package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Repository.MedicalBillRepository;
import com.ltnc.JavaApp.Service.NotificationService.FinancialNotifyListener;
import com.ltnc.JavaApp.Service.NotificationService.NotifyListener;
import com.ltnc.JavaApp.Service.NotificationService.NotifyObserver;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddMedicalBillService implements IAddMedicalBill {
    @Resource
    private MedicalBillRepository medicalBillRepository;
    @Resource
    private NotifyObserver notifyObserver;
    @Override
    public void addMedicalBill(MedicalBill medicalBill,FinancialEmployee financialEmployee) throws NullPointerException{
        medicalBillRepository.save(medicalBill);
        financialEmployee.addMedicalBill(medicalBill);
        NotifyListener notifyListenerEmployee = new FinancialNotifyListener(financialEmployee);
        NotifyListener notifyListenerPatient = new FinancialNotifyListener(medicalBill.getPatient());
        notifyObserver.addListener("financial",notifyListenerPatient);
        notifyObserver.addListener("financial",notifyListenerEmployee);
    }
}
