package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Authentication.JwtGeneratorValidator;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.UserAccount;
import com.ltnc.JavaApp.RequestModel.UserAccount.LoginRequestModel;
import com.ltnc.JavaApp.RequestModel.UserAccount.PatientAccountRegisterRequestModel;
import com.ltnc.JavaApp.Service.AccountService.IRegisterService;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.PatientProfileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    IRegisterService registerService;
    @Autowired
    PatientProfileManageService patientProfileManageService;
    @Autowired
    EmployeeProfileManageService employeeProfileManageService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtGeneratorValidator jwtGeneratorValidator;

    @PostMapping("/patient/register")
    public void registerAccount(@RequestBody PatientAccountRegisterRequestModel detail){
        UserAccount account = detail.getUserAccount();
        Patient patient = detail.getPatient();
        account.setId(UUID.randomUUID().toString());
        account.setRole(patient.getRole());
        patient.setUserAccount(account);
        registerService.register(account);
        patientProfileManageService.createProfile(patient);
    }
    @PostMapping("/patient/login")
    public String patientLogin(@RequestBody LoginRequestModel loginRequestModel){
        Authentication authentication = authenticationManager.authenticate(loginRequestModel.getUsername(),a)
    }

}
