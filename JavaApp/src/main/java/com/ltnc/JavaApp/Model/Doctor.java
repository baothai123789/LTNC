package com.ltnc.JavaApp.Model;

import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Doctor")
public class Doctor extends Employee implements MedicalDetailModel {
    @Id
    private String id;
    private String major;
    @DBRef
    private List<MedicalDetail> medicalDetails=new ArrayList<>();
    @Override
    public String getId() {return id;}
    @Override
    public void setId(String id) {this.id = id;}
    @Override
    public String getRole() {return "doctor";}
    @Override
    public void addMedicalDetail(MedicalDetail medicalDetail) {
        this.medicalDetails.add(medicalDetail);
    }
    @Override
    public List<MedicalDetail> getMedicalDetails() {
        return this.medicalDetails;
    }
}