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

import java.util.List;
import java.util.Optional;

@Service
public class RemoveFromFundService {

    @Autowired
    private FinancialEmployeeRepository financialEmployeeRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private PatientRepository patientRepository;

    public void removeDoctorSalariesFromFund(String financialEmployeeId) {
        Optional<FinancialEmployee> optionalFinancialEmployee = financialEmployeeRepository.findById(financialEmployeeId);
        if (optionalFinancialEmployee.isPresent()) {
            FinancialEmployee financialEmployee = optionalFinancialEmployee.get();
            List<Doctor> doctors = doctorRepository.findAll();
            long salary = doctors.stream().mapToLong(Doctor::getSalary).sum();
            financialEmployee.minustoFund(salary);
            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Financial Employee not found with id: " + financialEmployeeId);
        }
    }

    public void removeNurseSalariesFromFund(String financialEmployeeId) {
        Optional<FinancialEmployee> optionalFinancialEmployee = financialEmployeeRepository.findById(financialEmployeeId);
        if (optionalFinancialEmployee.isPresent()) {
            FinancialEmployee financialEmployee = optionalFinancialEmployee.get();
            List<Nurse> nurses = nurseRepository.findAll();
            long salary = nurses.stream().mapToLong(Nurse::getSalary).sum();
            financialEmployee.minustoFund(salary);
            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Financial Employee not found with id: " + financialEmployeeId);
        }
    }

    public void removePatientFeesFromFund(String financialEmployeeId) {
        Optional<FinancialEmployee> optionalFinancialEmployee = financialEmployeeRepository.findById(financialEmployeeId);
        if (optionalFinancialEmployee.isPresent()) {
            FinancialEmployee financialEmployee = optionalFinancialEmployee.get();
            List<Patient> patients = patientRepository.findAll();
            long salary = patients.stream().mapToLong(Patient::getFee).sum();
            financialEmployee.minustoFund(salary);
            financialEmployeeRepository.save(financialEmployee);
        } else {
            throw new RuntimeException("Financial Employee not found with id: " + financialEmployeeId);
        }
    }
}
