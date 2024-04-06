package com.ltnc.JavaApp.Service.MedicalDetailService.Service;
import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Repository.MedicalDetailRepository;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.IAddMedicalDetailService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.ICreateMedicalDetailService;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CreateMedicalDetailService implements ICreateMedicalDetailService {
    @Autowired
    private MedicalDetailRepository repository;
    @Autowired
    private IAddMedicalDetailService addMedicalDetailService;
    @Override
    public String createMedicalDetail(MedicalDetail newmedicaldetail,String patientId,String doctorId) {
        List<MedicalDetailModel> res = addMedicalDetailService.addMedicalDetail(doctorId,patientId,newmedicaldetail);
        repository.save(newmedicaldetail);
        return "success";

    }
}
