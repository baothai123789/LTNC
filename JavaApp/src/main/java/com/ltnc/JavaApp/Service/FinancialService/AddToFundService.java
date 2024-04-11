package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Repository.NurseRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddToFundService {
    @Autowired
    private  FinancialEmployeeRepository financialEmployeeRepository;
    private  DoctorRepository doctorRepository;
    private  NurseRepository nurseRepository;
    private  PatientRepository patientRepository;


    public void addDoctorSalariesToFund(String financialEmployeeId) {
        Optional<FinancialEmployee> optionalFinancialEmployee = financialEmployeeRepository.findById(financialEmployeeId);
        if (optionalFinancialEmployee.isPresent()) {
            FinancialEmployee financialEmployee = optionalFinancialEmployee.get();
            List<Doctor> doctors = doctorRepository.findAll();
            long totalDoctorSalaries = doctors.stream().mapToLong(Doctor::getSalary).sum();
            financialEmployee.addToFund(totalDoctorSalaries);
            financialEmployeeRepository.save(financialEmployee);
        }
        else {
            throw new RuntimeException("Financial Employee not found with id: " + financialEmployeeId);
        }
    }
    public void addPatientFeesToFund(String financialEmployeeId) {
        Optional<FinancialEmployee> optionalFinancialEmployee = financialEmployeeRepository.findById(financialEmployeeId);
        if (optionalFinancialEmployee.isPresent()) {
            FinancialEmployee financialEmployee = optionalFinancialEmployee.get();
            List<Patient> patients = patientRepository.findAll();
            long totalPatientFees = patients.stream().mapToLong(Patient::getFee).sum();
            financialEmployee.addToFund(totalPatientFees);
            financialEmployeeRepository.save(financialEmployee);
        }
        else {
            throw new RuntimeException("Financial Employee not found with id: " + financialEmployeeId);
        }
    }
}
