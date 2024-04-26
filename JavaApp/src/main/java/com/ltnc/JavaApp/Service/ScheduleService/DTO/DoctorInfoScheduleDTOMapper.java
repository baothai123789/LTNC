package com.ltnc.JavaApp.Service.ScheduleService.DTO;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.DoctorInfoDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorInfoScheduleDTOMapper {
    public DoctorInfoScheduleDTO map(Doctor doctor, List<Integer> times){
        return DoctorInfoScheduleDTO.builder()
                .doctorInfo(new DoctorInfoDTO(doctor))
                .doctorScheduleDTOs(times.stream().map(time->new DoctorScheduleDTO(time,time+1)).toList())
                .build();
    }
}
