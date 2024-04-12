package com.ltnc.JavaApp.Service.MedicalDetailService.Service;

import com.ltnc.JavaApp.Model.MedicalDetail;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDetailManageService implements IMedicalDetailManageService {
    @Autowired
    private List<IAddMedicalDetailService> addMedicalDetailServices;

    @Autowired
    private IUpdateMedicalDetailService updateMedicalDetailService;

    @Autowired
    List<IGetMedicalDetailService> getMedicalDetailServices;
    @Autowired
    IGetMedicalDetailById getMedicalDetailById;


    @Override
    public void addMedicalDetail(MedicalDetail medicalDetail, String model,String type) throws NullPointerException {
         IAddMedicalDetailService addService=this.addMedicalDetailServices.stream()
                 .filter(service->service.getType()
                         .equalsIgnoreCase(type)).findFirst().orElseThrow(NullPointerException::new);
         try{
             addService.addMedicalDetail(model,medicalDetail);
         }
         catch(Exception e){
             throw new NullPointerException("not found user");
         }
    }

    @Override
    public void updateMedicalDetail(MedicalDetail medicalDetail, String medicalId) {
        this.updateMedicalDetailService.updateMedicalDetail(medicalId,medicalDetail);
    }

    @Override
    public List<MedicalDetail> getMedicalDetail(String modelId, String type) {
        IGetMedicalDetailService getService=this.getMedicalDetailServices.stream()
                .filter(service->service.getType()
                        .equalsIgnoreCase(type)).findFirst().orElseThrow(NullPointerException::new);
        List<MedicalDetail> res;
        try{
            res = getService.getMedicalDetails(modelId);
        }
        catch(Exception e){
            throw new NullPointerException("not found user");
        }
        return res;
    }

    @Override
    public MedicalDetail getMedicalDetailById(String medicalDetailId) {
        MedicalDetail res;
        try{
            res = this.getMedicalDetailById.getMedicalDetail(medicalDetailId);
        }
        catch (NullPointerException e){
            throw new NullPointerException("Medical Detail not found");
        }
        return res;
    }
}
