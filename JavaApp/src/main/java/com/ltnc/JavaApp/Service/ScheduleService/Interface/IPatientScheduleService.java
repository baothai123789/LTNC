package com.ltnc.JavaApp.Service.ScheduleService.Interface;

import com.ltnc.JavaApp.Model.MedicalSchedule;
import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.PatientScheduleDTO;

import java.time.LocalDate;
import java.util.List;

public interface IPatientScheduleService {
    public PatientScheduleDTO patientSchedule(LocalDate date,String doctorid,String patientid) throws NullPointerException;

}
