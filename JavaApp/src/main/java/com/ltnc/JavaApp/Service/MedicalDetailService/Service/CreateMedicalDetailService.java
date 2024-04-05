package com.ltnc.JavaApp.Service.MedicalDetailService.Service;
import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Service.EditProfileService.Employee.Interface.IEmployeeEditProfileService;
import com.ltnc.JavaApp.Service.EditProfileService.Patient.Interface.IPatientEditProfileService;
import com.ltnc.JavaApp.Service.EditProfileService.Factory.EditprofileServiceFactory;
import com.ltnc.JavaApp.Service.InformationService.Factory.InformationServiceFactory;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.ICreateMedicalDetailService;
import com.ltnc.JavaApp.Service.InformationService.Interface.IInfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateMedicalDetailService implements ICreateMedicalDetailService {
    @Autowired
    private MedicalDetailRepository repository;

    @Autowired
    private  InformationServiceFactory informationServiceFactory;
    @Autowired
    private EditprofileServiceFactory editprofileServiceFactory;
    @Autowired
    private IPatientEditProfileService patientEditProfileService;

    @Override
    public String createMedicalDetail(MedicalDetail newmedicaldetail,String patientId,String doctorId) {
       IInfomationService infopatient= informationServiceFactory.getInfomationService("patient").orElse(null);
       IInfomationService infodoctor = informationServiceFactory.getInfomationService("doctor").orElse(null);
       if(infodoctor==null|infodoctor==null) return "Service info not found";
       Patient patient = (Patient) (infopatient != null ? infopatient.getData(patientId).orElse(null) : null);
       if(patient==null) return "patient not found";
       Doctor doctor = (Doctor) infodoctor.getData(doctorId).orElse(null);
       if(doctor==null) return "doctor not found";
       newmedicaldetail.setId(UUID.randomUUID().toString());
       patient.addMedicalDetail(newmedicaldetail);
       doctor.addMedicalDetail(newmedicaldetail);
       try{
           repository.save(newmedicaldetail);
       }
       catch (Exception e){
           MyApp.LOGGER.info(e.getMessage());
           return "save Medical Detail fail";
       }
       IEmployeeEditProfileService doctoreditprofile = editprofileServiceFactory.getService("doctor").orElse(null);
       if(doctoreditprofile==null) return "Doctor Edit Profile Service not found";
       try {
           doctoreditprofile.editProfile(doctorId,doctor);
       }
       catch (Exception e){
           MyApp.LOGGER.info(e.getMessage());
           return "save profile doctor fail";
       }
       try {
           patientEditProfileService.editProfile(patientId,patient);
       }
       catch (Exception e){
           MyApp.LOGGER.info(e.getMessage());
           return "save profile patient fail";
       }
       return "success";
    }
}
