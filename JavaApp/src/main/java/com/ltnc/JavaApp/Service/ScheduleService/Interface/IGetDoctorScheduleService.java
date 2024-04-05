package com.ltnc.JavaApp.Service.ScheduleService.Interface;



import com.ltnc.JavaApp.Model.Doctor;

import java.time.LocalDate;
import java.util.List;

public interface IGetDoctorScheduleService {
    public List<Integer> getDoctorSchedule(String doctorid, LocalDate date);
}
