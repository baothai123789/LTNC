package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.MyApp;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalBillManage {

    @Resource
    IGetMedicalBill getMedicalBill;
    @Resource
    IUpdateMedicalBill updateMedicalBill;
    @Resource
    FinacialBillDTOMapper finacialBillDTOMapper;
    @Resource
    IAddMedicalBill addMedicalBill;


    public void paytheBill(String billId){
        this.updateMedicalBill.payBill(billId);
    }
    public List<FinacialBillDTO> getMedicalBills(String employeeId,Boolean paid){
        List<MedicalBill> res=this.getMedicalBill.getMedicalBills(employeeId,paid);
        MyApp.LOGGER.info(res);
        return res.stream().map(medicalBill -> finacialBillDTOMapper.map(medicalBill,"financialemployee")).toList();
    }
    public void addMedicalBill(MedicalBill medicalBill, FinancialEmployee financialEmployee, Patient patient){
        medicalBill.setFinancialEmployeeId(financialEmployee.getId());
        this.addMedicalBill.addMedicalBill(medicalBill,financialEmployee,patient);
    }
    public List<FinacialBillDTO> getPatientMedicalBill(String patientId){
        List<MedicalBill> res = this.getMedicalBill.getPatientMedicalBill(patientId);
        return res.stream().map(medicalBill -> finacialBillDTOMapper.map(medicalBill,"patient")).toList();
    }

}
