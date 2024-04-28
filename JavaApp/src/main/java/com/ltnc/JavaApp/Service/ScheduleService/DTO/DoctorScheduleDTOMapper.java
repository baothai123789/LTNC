package com.ltnc.JavaApp.Service.ScheduleService.DTO;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.Schedule;
import org.springframework.stereotype.Component;

@Component
public class DoctorScheduleDTOMapper {
    public ScheduleDTO map(Schedule schedule, Patient patient){
        return DoctorScheduleDTO.builder()
                .date(schedule.getDate())
                .id(schedule.getId())
                .patientInfo(new PatientInfoDTO(patient))
                .time(schedule.getStartTime())
                .build();
    }
}
