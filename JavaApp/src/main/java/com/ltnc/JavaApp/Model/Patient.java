package com.ltnc.JavaApp.Model;
import java.util.ArrayList;
import java.util.List;

import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Patient")
public class Patient extends Person  implements MedicalDetailModel {
    @Id
    private String id;
    private List<MedicalRecord> medicalrecord=new ArrayList<>();

    @DBRef
    List<MedicalDetail> medicalDetails=new ArrayList<>();

    @Override
    public void addMedicalDetail(MedicalDetail medicalDetail) {
        this.medicalDetails.add(medicalDetail);
    }
    @Override
    public List<MedicalDetail> getMedicalDetails() {
        return medicalDetails;
    }
}
