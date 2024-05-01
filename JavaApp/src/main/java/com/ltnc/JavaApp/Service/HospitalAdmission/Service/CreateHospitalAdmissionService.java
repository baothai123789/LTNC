package com.ltnc.JavaApp.Service.HospitalAdmission.Service;

import com.ltnc.JavaApp.Model.*;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Repository.NurseRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.NurseDTOMapper;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.NurseInfoDTO;
import com.ltnc.JavaApp.Service.MedicalDetailService.Service.MedicalDetailManageService;
import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import com.ltnc.JavaApp.Service.ProfileService.Employee.EmployeeProfileManageService;
import com.ltnc.JavaApp.Service.ProfileService.Patient.PatientProfileManageService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CreateHospitalAdmissionService {
    @Resource
    FindNurseService findNurse;
    @Resource
    private HospitalAdmissionManageService hospitalAdmissionManageService;
    @Resource
    EmployeeProfileManageService employeeProfileManageService;
    @Resource
    NotificationManage notificationManage;
    @Resource
    MedicalDetailManageService medicalDetailManageService;
    @Resource
    PatientProfileManageService patientProfileManageService;
    private void sendNotifytoNurse(Nurse nurse,HospitalAdmissionDetail hospitalAdmissionDetail){
        Notification notification = new Notification();
        notification.setDateTime(LocalDateTime.now());
        notification.setTitle("Hồ sơ nhập viện");
        notification.setBody("Bạn có hồ sơ nhập viện mới của bệnh nhân"+hospitalAdmissionDetail.getId());
        notificationManage.sendNotification(notification,nurse);
    }
    private void sendNotifytoPatient(HospitalAdmissionDetail hospitalAdmissionDetail,String nursePhone){
        Patient patient = patientProfileManageService.getProfile(hospitalAdmissionDetail.getPatientId());
        Notification notification_patient= new Notification();
        notification_patient.setTitle("Lịch nhập viện");
        notification_patient.setBody("Bạn có lịch nhập viện vào ngày " +hospitalAdmissionDetail.getStartDate()
                +". Vui lòng liên hệ với y tá qua số điện thoại:"+
                nursePhone+" Mã hồ sơ khám bệnh yêu cầu nhập viện:"+
                hospitalAdmissionDetail.getMedicalDetail().getId()+". Mã hồ sơ nhập viện của bạn là:"
                +hospitalAdmissionDetail.getId());
        notificationManage.sendNotification(notification_patient,patient);
    }

    public NurseInfoDTO createHospitalAdmission(HospitalAdmissionDetail hospitalAdmissionDetail){
        hospitalAdmissionDetail.setId(UUID.randomUUID().toString());
        MedicalDetail medicalDetail = medicalDetailManageService.getMedicalDetail(hospitalAdmissionDetail.getMedicalDetail().getId());
        hospitalAdmissionDetail.setMedicalDetail(medicalDetail);
        Nurse nurse = findNurse.findNurse();
        hospitalAdmissionManageService.addHospitalAdmission(hospitalAdmissionDetail,nurse);
        employeeProfileManageService.UpdateUserProfile(nurse);
        sendNotifytoNurse(nurse,hospitalAdmissionDetail);
        sendNotifytoPatient(hospitalAdmissionDetail,nurse.getPhone());
        NurseDTOMapper nurseDTOMapper = new NurseDTOMapper();
        return nurseDTOMapper.map(nurse);
    }
}
