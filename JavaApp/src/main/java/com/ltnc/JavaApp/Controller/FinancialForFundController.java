package com.ltnc.JavaApp.Controller;

import com.ltnc.JavaApp.Model.*;
import com.ltnc.JavaApp.Service.FinancialService.Interface.IAddToFundService;
import com.ltnc.JavaApp.Service.FinancialService.Interface.IGetTotalFundService;
import com.ltnc.JavaApp.Service.FinancialService.Interface.IRemoveFromFundService;
import com.ltnc.JavaApp.Service.FinancialService.Interface.ISetFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/financial/fund")
public class FinancialForFundController {

    @Autowired
    private ISetFundService setFundService;

    @Autowired
    private IAddToFundService addToFundService;

    @Autowired
    private IRemoveFromFundService removeFromFundService;

    @Autowired
    private IGetTotalFundService getTotalFundService;

    @PostMapping("/setFund/financialEmployee")
    public void setOriginalFund(@RequestBody FinancialEmployee financialEmployee,@RequestParam long fund){
        setFundService.setOriginalFund(financialEmployee,fund);
    }

    @PostMapping("/addFee")
    public void addFeeToFund(@RequestBody Patient patient) {
        addToFundService.addFeeToFund(patient);
    }

    @PostMapping("/deductDoctorSalary")
    public void deductDoctorSalaryFromFund(@RequestBody Doctor doctor) {
        removeFromFundService.deductDoctorSalaryFromFund(doctor);
    }

    @PostMapping("/deductNurseSalary")
    public void deductNurseSalaryFromFund(@RequestBody Nurse nurse) {
        removeFromFundService.deductNurseSalaryFromFund(nurse);
    }

    @PostMapping("/deductPharmacyManagerSalary")
    public void deductPharmacyManagerSalaryFromFund(@RequestBody PharmacyManager pharmacyManager) {
        removeFromFundService.deductPharmacyManagerSalaryFromFund(pharmacyManager);
    }

    @GetMapping("/totalFund")
    public long getTotalFund() {
        return getTotalFundService.getTotalFund();
    }
}
