package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.FinancialEmployee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Model.PharmacyManager;
import com.ltnc.JavaApp.Service.FinancialService.Interface.IAddToListOfEmployeeService;
import com.ltnc.JavaApp.Service.FinancialService.Interface.IGetSalaryOfEmployeeService;
import com.ltnc.JavaApp.Service.FinancialService.Interface.ISetToListOfEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/financial/employee")
public class FinancialForEmployeeController {

    @Autowired
    private IAddToListOfEmployeeService addToListOfEmployeeService;

    @Autowired
    private ISetToListOfEmployeeService setToListOfEmployeeService;

    @Autowired
    private IGetSalaryOfEmployeeService getSalaryOfEmployeeService;

    @PostMapping("/add/doctor")
    public void addDoctorToMap(@RequestBody FinancialEmployee financialEmployee, @RequestBody Doctor doctor) {
        addToListOfEmployeeService.addDoctorToMap(financialEmployee, doctor);
    }

    @PostMapping("/add/nurse")
    public void addNurseToMap(@RequestBody FinancialEmployee financialEmployee, @RequestBody Nurse nurse) {
        addToListOfEmployeeService.addNurseToMap(financialEmployee, nurse);
    }

    @PostMapping("/add/pharmacyManager")
    public void addPharmacyManagerToMap(@RequestBody FinancialEmployee financialEmployee, @RequestBody PharmacyManager pharmacyManager) {
        addToListOfEmployeeService.addPharmacyManagerToMap(financialEmployee, pharmacyManager);
    }

    @PostMapping("/set/doctor")
    public void setDoctorMap(@RequestBody Doctor doctor, @RequestParam int salary) {
        setToListOfEmployeeService.setDoctorMap(doctor, salary);
    }

    @PostMapping("/set/nurse")
    public void setNurseMap(@RequestBody Nurse nurse, @RequestParam int salary) {
        setToListOfEmployeeService.setNurseMap(nurse, salary);
    }

    @PostMapping("/set/pharmacyManager")
    public void setPharmacyManagerMap(@RequestBody PharmacyManager pharmacyManager, @RequestParam int salary) {
        setToListOfEmployeeService.setPharmacyManagerMap(pharmacyManager, salary);
    }

    @GetMapping("/doctor/salary")
    public int getDoctorSalary(@RequestBody Doctor doctor) {
        return getSalaryOfEmployeeService.getDoctorSalary(doctor);
    }

    @GetMapping("/nurse/salary")
    public int getNurseSalary(@RequestBody Nurse nurse) {
        return getSalaryOfEmployeeService.getNurseSalary(nurse);
    }

    @GetMapping("/pharmacyManager/salary")
    public int getPharmacyManagerSalary(@RequestBody PharmacyManager pharmacyManager) {
        return getSalaryOfEmployeeService.getPharmacyManagerSalary(pharmacyManager);
    }
}
