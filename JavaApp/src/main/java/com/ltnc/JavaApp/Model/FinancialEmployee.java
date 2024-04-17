package com.ltnc.JavaApp.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "FinancialEmployee")
public class FinancialEmployee extends FunctionalEmployee {
    @Id
    private String id;

    @DBRef
    private List<MedicalBill> medicalBill=new ArrayList<>();
    @Setter
    @DBRef
    private UserAccount userAccount;
    private Integer amountofBillPaid=0;

    @Override
    public String getPart() {
        return "financialemployee";
    }



    public void addMedicalBill(MedicalBill medicalBill){
        this.amountofBillPaid++;
        this.medicalBill.add(medicalBill);
    }
    public void paytheBill(String billId){
        for(MedicalBill bill:medicalBill){
            if(bill.getId().equals(billId)){
                bill.setPaid(true);
                this.amountofBillPaid--;
            }
        }
    }

}
