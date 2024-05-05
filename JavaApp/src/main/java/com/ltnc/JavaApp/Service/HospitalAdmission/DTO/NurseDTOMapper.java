package com.ltnc.JavaApp.Service.HospitalAdmission.DTO;

import com.ltnc.JavaApp.Model.Nurse;
import org.springframework.stereotype.Service;


@Service
public class NurseDTOMapper {

    public NurseInfoDTO map(Nurse nurse) {
        return NurseInfoDTO.builder()
                .age(nurse.getAge())
                .phone(nurse.getPhone())
                .id(nurse.getId())
                .name(nurse.getName())
                .gender(nurse.getGender())
                .position(nurse.getPosition())
                .build();
    }
}
