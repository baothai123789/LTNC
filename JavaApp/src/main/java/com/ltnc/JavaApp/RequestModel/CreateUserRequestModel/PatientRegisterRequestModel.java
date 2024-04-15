package com.ltnc.JavaApp.RequestModel.CreateUserRequestModel;

import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRegisterRequestModel {
    private Patient patient;
    private UserAccount userAccount;
}
