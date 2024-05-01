package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class FinacialBillDTOMapper {
    @Resource
    EmployeeProfileManageService employeeProfileManageService;
    public FinacialBillDTO map(MedicalBill medicalBill,String type){
        return FinacialBillDTO.builder()
                .id(medicalBill.getId())
                .paid(medicalBill.getPaid())
                .type(medicalBill.getType())
                .medicalFee(medicalBill.getMedicalFee())
                .hastopay(medicalBill.getHastopay())
                .prescription(medicalBill.getPrescription())
                .totalPay(medicalBill.getTotalPay())
                .contactInfoDTO(new ContactInfoDTO(
                        type.equalsIgnoreCase("patient")?
                        medicalBill.getPatient()
                                :employeeProfileManageService.getEmployeeProfile(medicalBill.getFinancialEmployeeId(),"financialemployee"))
                ).build();
    }
}
