package com.ltnc.JavaApp.Service.HospitalAdmission.Service;

import com.ltnc.JavaApp.Model.*;
import com.ltnc.JavaApp.MyApp;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Repository.NurseRepository;
import com.ltnc.JavaApp.Repository.PatientRepository;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.NurseDTOMapper;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.NurseInfoDTO;
import com.ltnc.JavaApp.Service.NotificationService.NotificationManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class CreateHospitalAdmissionService {
    @Autowired
    private HospitalAdmissionManageService hospitalAdmissionManageService;
    @Autowired
    NurseRepository nurseRepository;
    @Autowired
    NotificationManage notificationManage;
    @Autowired
    MedicalDetailRepository medicalDetailRepository;
    @Autowired
    PatientRepository patientRepository;

    private Nurse findNurse(){
        List<Nurse> nurses = nurseRepository.findAll();
         return nurses.stream().filter(nurse -> nurse.getHospitalAdmissionDetails().size()<10).findFirst().orElseThrow(NullPointerException::new);
    }
    private void sendNotifytoNurse(Nurse nurse,HospitalAdmissionDetail hospitalAdmissionDetail){
        Notification notification = new Notification();
        notification.setDateTime(LocalDateTime.now());
        notification.setTitle("Hồ sơ nhập viện");
        notification.setBody("Bạn có hồ sơ nhập viện mới của bệnh nhân"+hospitalAdmissionDetail.getId());
        notificationManage.sendNotification(notification,nurse);
    }
    private void sendNotifytoPatient(HospitalAdmissionDetail hospitalAdmissionDetail,String nursePhone){
        Patient patient = patientRepository.findById(hospitalAdmissionDetail.getPatientId()).orElseThrow(()->new NullPointerException("patient not found"));
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
        MedicalDetail medicalDetail = medicalDetailRepository.findById(hospitalAdmissionDetail.getMedicalDetail().getId())
                .orElseThrow(()->new NullPointerException("cannot find medical detai"));
        hospitalAdmissionDetail.setMedicalDetail(medicalDetail);
        Nurse nurse = findNurse();
        MyApp.LOGGER.info(nurse);
        hospitalAdmissionManageService.addHospitalAdmission(hospitalAdmissionDetail,nurse);
        sendNotifytoNurse(nurse,hospitalAdmissionDetail);
        sendNotifytoPatient(hospitalAdmissionDetail,nurse.getPhone());
        NurseDTOMapper nurseDTOMapper = new NurseDTOMapper();
        return nurseDTOMapper.map(nurse);
    }
}
