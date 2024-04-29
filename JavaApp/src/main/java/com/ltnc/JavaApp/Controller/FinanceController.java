package com.ltnc.JavaApp.Controller;


import com.ltnc.JavaApp.Service.FinancialService.FinacialBillDTO;
import com.ltnc.JavaApp.Service.FinancialService.MedicalBillManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/finance")
public class FinanceController {
    @Autowired
    MedicalBillManage medicalBillManage;
    @PreAuthorize("hasAuthority('financialemployee')")
    @PutMapping("paybill/{billid}")
    public ResponseEntity<HashMap<String,String>> payBill(@PathVariable("billid") String billid){
        try {
            medicalBillManage.paytheBill(billid);
        }
        catch (NullPointerException e){
            return new ResponseEntity<>(new HashMap<>(Map.of("message",e.getMessage())), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(new HashMap<>(Map.of("message","success")),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('financialemployee')")
    @GetMapping("/getmedicalbill/{employeeid}/{haspaid}")
    public ResponseEntity<List<FinacialBillDTO>> getMedicalBill(@PathVariable("employeeid")String employeeid,@PathVariable("haspaid") String haspaid){
        List<FinacialBillDTO> res;
        try{
            res = medicalBillManage.getMedicalBills(employeeid, haspaid.equalsIgnoreCase("true"));
        }
        catch (NullPointerException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
