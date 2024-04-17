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
    IGetMedicalBill getMedicalBill;
    @Autowired
    IUpdateMedicalBill updateMedicalBill;
    @Autowired
    FinacialBillDTOMapper finacialBillDTOMapper;


    public void paytheBill(String employeeId,String billId){
        this.updateMedicalBill.payBill(billId,employeeId);
    }
    public List<FinacialBillDTO> getMedicalBills(String employeeId,Boolean paid){
        List<MedicalBill> res=this.getMedicalBill.getMedicalBills(employeeId,paid);
        return res.stream().map(medicalBill -> finacialBillDTOMapper.map(medicalBill)).toList();
    }
}
