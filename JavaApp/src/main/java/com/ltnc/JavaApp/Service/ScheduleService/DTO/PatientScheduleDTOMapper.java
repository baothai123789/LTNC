package com.ltnc.JavaApp.Service.ScheduleService.DTO;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Schedule;
import org.springframework.stereotype.Component;

@Component
public class PatientScheduleDTOMapper {
    public PatientScheduleDTO map(Schedule schedule, Doctor doctor){
        return PatientScheduleDTO.builder()
                .date(schedule.getDate())
                .id(schedule.getId())
                .doctorInfo(new DoctorInfoDTO(doctor))
                .time(schedule.getStartTime())
                .build();
    }
}
