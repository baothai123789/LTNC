package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Authentication.JwtGeneratorValidator;
import com.ltnc.JavaApp.Model.Employee;

import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.UserAccount;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.RequestModel.CreateUserRequestModel.EmployeeLoginModel;
import com.ltnc.JavaApp.RequestModel.CreateUserRequestModel.EmployeeRegisterRequestModel;
import com.ltnc.JavaApp.RequestModel.CreateUserRequestModel.LoginModel;
import com.ltnc.JavaApp.RequestModel.CreateUserRequestModel.PatientRegisterRequestModel;
import com.ltnc.JavaApp.Service.AccountService.CustomUserDetails;
import com.ltnc.JavaApp.Service.AccountService.Exception.UnvalidAccountException;
import com.ltnc.JavaApp.Service.AccountService.IUserManageService;
import com.ltnc.JavaApp.Service.AccountService.RegisterService;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.PatientProfileManageService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/account")
public class AccountController {
    @Resource
    RegisterService registerService;
    @Resource
    PatientProfileManageService patientProfileManageService;
    @Resource
    EmployeeProfileManageService employeeProfileManageService;
    @Resource
    AuthenticationManager authenticationManager;
    @Resource
    JwtGeneratorValidator jwtGeneratorValidator;

    @Resource
    IUserManageService userManageService;

    @PostMapping("/patient/register")
    public ResponseEntity<Map<String,String>> registerAccount(@RequestBody PatientRegisterRequestModel patientRegisterRequestModel){
        Patient patient = patientRegisterRequestModel.getPatient();
        UserAccount userAccount = patientRegisterRequestModel.getUserAccount();
        userAccount.setRole(patient.getRole());
        userAccount.setId(UUID.randomUUID().toString());
        patient.setUserAccount(userAccount);
        try{
        registerService.register(userAccount);
        }
        catch (UnvalidAccountException e){
            return new ResponseEntity<>(new HashMap<>(Map.of("message",e.getMessage())),HttpStatus.NOT_ACCEPTABLE);
        }
        patientProfileManageService.createProfile(patient);
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
        userAccount.setId(UUID.randomUUID().toString());
        employee.setUserAccount(userAccount);
        try {
            registerService.register(userAccount);
        }
        catch (UnvalidAccountException e){
            MyApp.LOGGER.info(e);
            return new ResponseEntity<>(new HashMap<>(Map.of("message",e.getMessage())),HttpStatus.NOT_ACCEPTABLE);
        }
        employeeProfileManageService.createEmployeeProfile(employee,userAccount.getRole());
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
    @PreAuthorize("hasAnyAuthority('patient','doctor','nurse','financialemployee','pharmacymanager')")
    @GetMapping("/getuserid/{username}")
    public ResponseEntity<Map<String,String>> getUserId(@PathVariable("username") String username){
        try{
            Map<String,String> res = userManageService.getUserId(username);
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new HashMap<>(Map.of("error",e.getMessage())),HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/employee/login")
    public ResponseEntity<Map<String,String>> loginEmployeeAccount(@RequestBody EmployeeLoginModel employeeLoginModel){
        MyApp.LOGGER.info(employeeLoginModel.getRole());
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(employeeLoginModel.getUsername(),employeeLoginModel.getPassword(),
                            Collections.singleton(new SimpleGrantedAuthority(employeeLoginModel.getRole())))
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtGeneratorValidator.generateToken((CustomUserDetails) authentication.getPrincipal());
            return new ResponseEntity<>(new HashMap<>(Map.of("token",jwt)),HttpStatus.OK);
        }
        catch (Exception e){
            MyApp.LOGGER.info(e.getMessage());
        }
        return new ResponseEntity<>(new HashMap<>(Map.of("message","fail")),HttpStatus.NOT_ACCEPTABLE);
    }

}
