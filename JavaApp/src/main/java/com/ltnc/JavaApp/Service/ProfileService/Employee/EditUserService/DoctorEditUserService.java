package com.ltnc.JavaApp.Service.ProfileService.Employee.EditUserService;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
public class DoctorEditUserService extends AbstractEditUserService<Doctor>{
    @Autowired
    public DoctorEditUserService(DoctorRepository doctorRepository){
        this.modelRepository = doctorRepository;
        this.type=Doctor.class;
    }

    @Override
    public void editUser(String userId, Employee employee) {
        Doctor doctor = (Doctor) employee;
        Doctor doctor_db = ((DoctorRepository) this.modelRepository).findById(userId).orElseThrow(()-> new NullPointerException("user not found"));
        doctor_db.getSchedules().forEach(
                doctor::addSchedule
        );
        doctor_db.getMedicalDetails().forEach(
                doctor::addMedicalDetail
        );
        doctor.setUserAccount(doctor_db.getUserAccount());
        doctor.setCertificate(doctor_db.getCertificate());
        ((DoctorRepository) this.modelRepository).save(doctor);
    }
}
