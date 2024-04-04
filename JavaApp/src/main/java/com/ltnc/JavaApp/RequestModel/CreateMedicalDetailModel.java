package com.ltnc.JavaApp.RequestModel;

import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class CreateMedicalDetailModel {

    private MedicalDetail detail;
    private MedicalDetailInfo info;

    public CreateMedicalDetailModel(MedicalDetail detail, MedicalDetailInfo info) {
        this.detail = detail;
        this.info = info;
    }

    public CreateMedicalDetailModel() {
    }

    public MedicalDetail getDetail() {
        return detail;
    }

    public void setDetail(MedicalDetail detail) {
        this.detail = detail;
    }

    public MedicalDetailInfo getInfo() {
        return info;
    }

    public void setInfo(MedicalDetailInfo info) {
        this.info = info;
    }
}
