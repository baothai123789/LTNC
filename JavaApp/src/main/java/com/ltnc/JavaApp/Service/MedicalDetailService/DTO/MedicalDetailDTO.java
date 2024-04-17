package com.ltnc.JavaApp.Service.MedicalDetailService.DTO;

import com.ltnc.JavaApp.Model.MedicalDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class MedicalDetailDTO {
    MedicalDetailInfo medicalDetailInfo;
    MedicalDetail medicalDetail;
}
