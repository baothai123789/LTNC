package com.ltnc.JavaApp;

import com.ltnc.JavaApp.Model.*;
import com.ltnc.JavaApp.Repository.*;
import com.ltnc.JavaApp.Service.AccountService.UserAccountService;
import com.ltnc.JavaApp.Service.FinancialService.FinacialBillDTO;
import com.ltnc.JavaApp.Service.FinancialService.MedicalBillManage;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class JavaAppApplicationTests{
    @Autowired
    UserAccountService userAccountService;
    @Autowired
    UserAccountRepository userAccountRepository;
    @Test
    public void testMedicalBillRepository(){
        String username = "nhanvientaichinh123456";
        var personid = userAccountService.getUserId(username);
        MyApp.LOGGER.info(personid);

    }
}