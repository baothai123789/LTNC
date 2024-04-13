package com.ltnc.JavaApp.Service.FinancialService.Interface;

import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Patient;

public interface IAddToFundInterface {
    public void addFeeToFund(FinancialEmployee financialEmployee,Patient patient);

}
