package com.ltnc.JavaApp.Model;

import com.ltnc.JavaApp.Service.HospitalAdmission.Interface.IHospitalAdmissionManager;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Document(collection = "Nurse")
public class Nurse extends Employee implements IHospitalAdmissionManager {
    @Id
    private String id;
    @DBRef
    private List<HospitalAdmissionDetail> hospitalAdmissionDetails=new ArrayList<>();

    public Nurse() {}
    @Override
    public String getRole(){
        return "nurse";
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int getPatientAmount() {
        return this.hospitalAdmissionDetails.size();
    }

    @Override
    public void addHospitalAdmissionDetail(HospitalAdmissionDetail hospitalAdmissionDetail) {
        this.hospitalAdmissionDetails.add(hospitalAdmissionDetail);
    }

    @Override
    public List<HospitalAdmissionDetail> getHospitalAdmissionDetails() {
        return this.hospitalAdmissionDetails;
    }

    @Override
    public void updateHospitalAdmission(HospitalAdmissionDetail newHospitalAddmissionDetail) {
        int i=0;
        for(HospitalAdmissionDetail hospitalAdmissionDetail:hospitalAdmissionDetails){
            if(hospitalAdmissionDetail.getId().equals(newHospitalAddmissionDetail.getId())){
                this.hospitalAdmissionDetails.set(i,newHospitalAddmissionDetail);
                break;
            }
            i++;
        }
    }

    @Override
    public void removeHospitalAdmission(String detailId) {
        int i = 0;
        for(HospitalAdmissionDetail hospitalAdmissionDetail:hospitalAdmissionDetails){
            if(hospitalAdmissionDetail.getId().equals(detailId)){
                this.hospitalAdmissionDetails.remove(i);
                break;
            }
            i++;
        }
    }
}
