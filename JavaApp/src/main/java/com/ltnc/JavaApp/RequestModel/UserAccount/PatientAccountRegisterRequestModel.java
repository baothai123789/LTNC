package com.ltnc.JavaApp.RequestModel.UserAccount;


import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAccountRegisterRequestModel {
    private UserAccount userAccount;
    private Patient patient;
}
