package com.ltnc.JavaApp;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class JavaAppApplicationTests{
    @Autowired
    DoctorRepository doctorRepository;
    @Test
    public void testDoctorRepository(){
        Doctor doctor = doctorRepository.findBySchedules("");
        assertThat(doctor).isEqualTo(null);

    }
}