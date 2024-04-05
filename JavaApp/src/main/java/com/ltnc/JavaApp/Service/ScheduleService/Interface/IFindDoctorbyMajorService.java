package com.ltnc.JavaApp.Service.ScheduleService.Interface;

import com.ltnc.JavaApp.Model.Doctor;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IFindDoctorbyMajorService {
    public List<Doctor> findDoctor(String major);
}
