package com.ltnc.JavaApp.Service.MedicalDetailService.Service;
import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.Schedule;
import com.ltnc.JavaApp.Service.EditProfileService.Employee.Interface.IEmployeeEditProfileService;
import com.ltnc.JavaApp.Service.EditProfileService.Patient.Interface.IPatientEditProfileService;
import com.ltnc.JavaApp.Service.EditProfileService.Factory.EditprofileServiceFactory;
import com.ltnc.JavaApp.Service.InformationService.Factory.InformationServiceFactory;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.IAddMedicalDetailService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.ICreateMedicalDetailService;
import com.ltnc.JavaApp.Service.InformationService.Interface.IInfomationService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.IAddScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.List;
import java.util.UUID;

@Component
public class CreateMedicalDetailService implements ICreateMedicalDetailService {
    @Autowired
    private MedicalDetailRepository repository;
    @Autowired
    private IAddMedicalDetailService addMedicalDetailService;
    @Autowired
    private IAddScheduleService addScheduleService;
    @Override
    public String createMedicalDetail(MedicalDetail newmedicaldetail,String patientId,String doctorId) {
        List<MedicalDetailModel> res = addMedicalDetailService.addMedicalDetail(doctorId,patientId,newmedicaldetail);
        Doctor doctor=(Doctor)res.get(0);
        Patient patient=(Patient)res.get(1);
        repository.save(newmedicaldetail);
        newmedicaldetail.getMedicalSchedules().forEach(
                schedule->addScheduleService.addSchedule(
                        new Schedule(UUID.randomUUID().toString(),schedule.getTime().toLocalDate(),
                                schedule.getTime().getHour(),patient,doctor,"tai kham")
                )
        );
        return "success";

    }
}
