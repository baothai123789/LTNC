package com.ltnc.JavaApp.Service.ScheduleService.Service;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.PatientProfileManageService;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.DoctorScheduleDTOMapper;
import com.ltnc.JavaApp.Service.ScheduleService.DTO.ScheduleDTO;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IGetScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;

@Service
public class DoctorGetScheduleService implements IGetScheduleService {
    @Autowired
    EmployeeProfileManageService employeeProfileManageService;
    @Autowired
    PatientProfileManageService patientProfileManageService;
    @Autowired
    DoctorScheduleDTOMapper doctorInfoScheduleDTOMapper;
    @Override
    public List<ScheduleDTO> getSchedules(String modelId) throws NullPointerException {
        Doctor doctor = (Doctor) employeeProfileManageService.getEmployeeProfile(modelId,"doctor");
        return doctor.getSchedules().stream().map(
                schedule -> doctorInfoScheduleDTOMapper.map(
                        schedule,patientProfileManageService.getProfile(schedule.getPatientId()))
        ).toList();
    }

    @Override
    public List<ScheduleDTO> getSchedules(String modelId, LocalDate date) throws NullPointerException {
        Doctor doctor = (Doctor)employeeProfileManageService.getEmployeeProfile(modelId,"doctor");
        return doctor.getSchedules().stream().filter(schedule -> schedule.getDate().equals(date))
                .map(schedule -> doctorInfoScheduleDTOMapper.map(
                        schedule,patientProfileManageService.getProfile(schedule.getPatientId()))
        ).toList();
    }

    @Override
    public String getType() {
        return "doctor";
    }
}
