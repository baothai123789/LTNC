package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Authentication.JwtGeneratorValidator;
import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.NotificationList;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.UserAccount;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.RequestModel.CreateUserRequestModel.EmployeeLoginModel;
import com.ltnc.JavaApp.RequestModel.CreateUserRequestModel.EmployeeRegisterRequestModel;
import com.ltnc.JavaApp.RequestModel.CreateUserRequestModel.LoginModel;
import com.ltnc.JavaApp.RequestModel.CreateUserRequestModel.PatientRegisterRequestModel;
import com.ltnc.JavaApp.Service.AccountService.CustomUserDetails;
import com.ltnc.JavaApp.Service.AccountService.RegisterService;
import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.PatientProfileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    RegisterService registerService;
    @Autowired
    PatientProfileManageService patientProfileManageService;
    @Autowired
    EmployeeProfileManageService employeeProfileManageService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtGeneratorValidator jwtGeneratorValidator;
    @Autowired
    BCryptPasswordEncoder cryptPasswordEncoder;
    @Autowired
    NotificationManage notificationManage;

    @PostMapping("/patient/register")
    public ResponseEntity<Map<String,String>> registerAccount(@RequestBody PatientRegisterRequestModel patientRegisterRequestModel){
        Patient patient = patientRegisterRequestModel.getPatient();
        UserAccount userAccount = patientRegisterRequestModel.getUserAccount();
        userAccount.setRole(patient.getRole());
        userAccount.setPassword(cryptPasswordEncoder.encode(userAccount.getPassword()));
        userAccount.setId(UUID.randomUUID().toString());
        patient.setUserAccount(userAccount);
        NotificationList notificationList=new NotificationList();
        patient.setNotifications(notificationList);
        notificationManage.createNotifications(patient.getNotifications());
        patientProfileManageService.createProfile(patient);
        registerService.register(userAccount);
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.CREATED);
    }
    @PostMapping("/employee/register")
    public ResponseEntity<Map<String,String>> registerEmployeeAccount(@RequestBody EmployeeRegisterRequestModel employeeRegisterRequestModel){
        Employee employee = employeeRegisterRequestModel.getEmployee();
        UserAccount userAccount = employeeRegisterRequestModel.getUserAccount();
        if(employee.getRole().equalsIgnoreCase("functionalemployee")){
            userAccount.setRole(employee.getPart());
        }
        else{
            userAccount.setRole(employee.getRole());
        }
        userAccount.setPassword(cryptPasswordEncoder.encode(userAccount.getPassword()));
        userAccount.setId(UUID.randomUUID().toString());
        employee.setUserAccount(userAccount);
        NotificationList notificationList = new NotificationList();
        employee.setNotifications(notificationList);
        notificationManage.createNotifications(employee.getNotifications());
        employeeProfileManageService.createEmployeeProfile(employee,userAccount.getRole());
        registerService.register(userAccount);
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.CREATED);
    }
    @PostMapping("/patient/login")
    public ResponseEntity<Map<String,String>> loginAccount(@RequestBody LoginModel loginModel){
        MyApp.LOGGER.info(loginModel.getUsername());
        MyApp.LOGGER.info(loginModel.getPassword());

         Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginModel.getUsername(),loginModel.getPassword(),
                        Collections.singleton(new SimpleGrantedAuthority("patient")))
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtGeneratorValidator.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new ResponseEntity<>(new HashMap<>(Map.of("token",jwt)),HttpStatus.OK);

    }
    @PostMapping("/employee/login")
    public ResponseEntity<Map<String,String>> loginEmployeeAccount(@RequestBody EmployeeLoginModel employeeLoginModel){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(employeeLoginModel.getUsername(),employeeLoginModel.getPassword(),
                        Collections.singleton(new SimpleGrantedAuthority(employeeLoginModel.getRole())))
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtGeneratorValidator.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new ResponseEntity<>(new HashMap<>(Map.of("token",jwt)),HttpStatus.OK);
    }

}