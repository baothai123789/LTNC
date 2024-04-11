package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import com.ltnc.JavaApp.Repository.FinancialEmployeeRepository;
import com.ltnc.JavaApp.Repository.NurseRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddToListService {
    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;
    private DoctorRepository doctorRepository;
    private NurseRepository nurseRepository;
    private PatientRepository patientRepository;

    public void addDoctorToFinancialEmployee(String financialEmployeeId, Doctor doctor) {
        Optional<FinancialEmployee> optionalFinancialEmployee = financialEmployeeRepository.findById(financialEmployeeId);
        if (optionalFinancialEmployee.isPresent()) {
            FinancialEmployee financialEmployee = optionalFinancialEmployee.get();
            financialEmployee.addDoctor(doctor);
            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Financial Employee not found with provided id");
        }
    }

    public void addNurseToFinancialEmployee(String financialEmployeeId, Nurse nurse) {
        Optional<FinancialEmployee> optionalFinancialEmployee = financialEmployeeRepository.findById(financialEmployeeId);
        if (optionalFinancialEmployee.isPresent()) {
            FinancialEmployee financialEmployee = optionalFinancialEmployee.get();
            financialEmployee.addNurse(nurse);
            financialEmployeeRepository.save(financialEmployee);
        }
        else {
            throw new RuntimeException("Financial Employee not found with provided id");
        }
    }
    public void addPatientToFinancialEmployee(String financialEmployeeId, Patient patient) {
        Optional<FinancialEmployee> optionalFinancialEmployee = financialEmployeeRepository.findById(financialEmployeeId);
        if (optionalFinancialEmployee.isPresent()) {
            FinancialEmployee financialEmployee = optionalFinancialEmployee.get();
            financialEmployee.addPatient(patient);
            financialEmployeeRepository.save(financialEmployee);
        }
        else {
            throw new RuntimeException("Financial Employee not found with provided id");
        }
    }

}
