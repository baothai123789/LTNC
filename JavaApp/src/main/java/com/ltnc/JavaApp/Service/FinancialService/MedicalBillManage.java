package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalBillManage {
    @Autowired
    IAddMedicalBill addMedicalBill;
    @Autowired
    IGetMedicalBill getMedicalBill;
    @Autowired
    IUpdateMedicalBill updateMedicalBill;

    public FinancialEmployee addMedicalBill(MedicalBill newmedicalBill){
        return this.addMedicalBill.addMedicalBill(newmedicalBill);
    }
    public void paytheBill(String employeeId,String billId){
        this.updateMedicalBill.payBill(billId,employeeId);
    }
    public List<MedicalBill> getMedicalBills(String employeeId,Boolean paid){
        return this.getMedicalBill.getMedicalBills(employeeId,paid);
    }
}
