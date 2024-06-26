package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.MedicalBill;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Model.Patient;
import com.mongodb.lang.Nullable;
import jakarta.annotation.Nonnull;

import java.util.List;
import java.util.Map;

public interface IMedicalBillCreator {

    public MedicalBill createBill(Map<String,Object> data,Patient patient);
    public String getType();
}
