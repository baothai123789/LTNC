package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.ResponseModel.ProfileResponse.EmployeeProfileResponseModel;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.PatientProfileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ltnc.JavaApp.ResponseModel.ProfileResponse.PatientProfileResponseModel;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    PatientProfileManageService patientProfileManageService;
    @Autowired
    EmployeeProfileManageService employeeProfileManageService;

    @GetMapping("/patient/getprofile/{id}")
    public ResponseEntity<PatientProfileResponseModel> getPatientProfile(@PathVariable("id") String id){
        Patient res;
        try {
            res=patientProfileManageService.getProfile(id);
        }
        catch (NullPointerException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new PatientProfileResponseModel(res), HttpStatus.OK);
    }
    @GetMapping("/employee/{type}/getprofile/{id}")
    public ResponseEntity<EmployeeProfileResponseModel> getEmployeeProfile(@PathVariable("id") String id,@PathVariable("type") String type ){
        Employee employee;
        try {
             employee=this.employeeProfileManageService.getEmployeeProfile(id,type);
        }
        catch (NullPointerException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new EmployeeProfileResponseModel(employee),HttpStatus.OK);
    }
    @PostMapping("/patient/createprofile/")
    public ResponseEntity<Map<String,String>> createPatientProfile(@RequestBody Patient patient){
        try {
            this.patientProfileManageService.createProfile(patient);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(new HashMap<>(Map.of("message",e.getMessage())),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.CREATED);
    }
    @PostMapping("/employee/createprofile")
    public ResponseEntity<Map<String,String>> createEmployeeProfile(@RequestBody Employee employee){
        try{
            if(employee.getRole().equalsIgnoreCase("functionalEmployee")){
                this.employeeProfileManageService.createEmployeeProfile(employee,employee.getPart());
            }
            else{
                this.employeeProfileManageService.createEmployeeProfile(employee,employee.getRole());
            }
        }
        catch (NullPointerException e){
            return new ResponseEntity<>(new HashMap<>(Map.of("message",e.getMessage())),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.CREATED);
    }
    @PutMapping("/patient/editprofile/{id}")
    public ResponseEntity<Map<String,String>> editPatientProfile(@RequestBody Patient patient,@PathVariable("id") String id){
        try {
            this.patientProfileManageService.editProfile(id,patient);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(new HashMap<>(Map.of("message",e.getMessage())),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.OK);
    }
    @PutMapping("/employee/editprofile/{id}")
    public ResponseEntity<Map<String,String>> editEmployeeProfile(@RequestBody Employee employee,@PathVariable("id")String id){
        try{
            if(employee.getRole().equalsIgnoreCase("functionalEmployee")){
                this.employeeProfileManageService.editEmployeeProfile(id,employee,employee.getPart());
            }
            else {
                this.employeeProfileManageService.editEmployeeProfile(id,employee,employee.getRole());
            }
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(new HashMap<>(Map.of("message",e.getMessage())),HttpStatus.NOT_ACCEPTABLE);
        }
        return  new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.OK);
    }
}
