package com.ltnc.JavaApp.Service.ProfileService.Employee.EditUserService;

import com.ltnc.JavaApp.Model.Employee;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NurseEditUserService extends AbstractEditUserService<Nurse>{
    @Autowired
    public NurseEditUserService(NurseRepository nurseRepository){
        this.modelRepository = nurseRepository;
        this.type=Nurse.class;
    }

    @Override
    public void editUser(String userId, Employee employee) {
        Nurse nurse_db = ((NurseRepository)this.modelRepository).findById(userId).orElseThrow(()->new NullPointerException("user not found"));
        Nurse nurse =(Nurse) employee;
        nurse_db.getHospitalAdmissionDetails().forEach(
                nurse::addHospitalAdmissionDetail
        );
        nurse.setUserAccount(nurse_db.getUserAccount());
        ((NurseRepository)this.modelRepository).save(nurse);
    }
}
