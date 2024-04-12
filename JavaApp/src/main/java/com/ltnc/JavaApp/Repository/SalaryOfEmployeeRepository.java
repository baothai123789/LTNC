package com.ltnc.JavaApp.Repository;

import com.ltnc.JavaApp.Model.SalaryOfEmployee;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface SalaryOfEmployeeRepository {

    Optional<SalaryOfEmployee> findById(String employeeSalaryId);
}
