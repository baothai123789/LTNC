package com.ltnc.JavaApp.Service.HospitalAdmission.Service;

import com.ltnc.JavaApp.Model.HospitalAdmissionDetail;
import com.ltnc.JavaApp.Model.Nurse;
import com.ltnc.JavaApp.Model.PatientState;
import com.ltnc.JavaApp.Service.HospitalAdmission.DTO.HospitalAdmissionDetailDTO;
import com.ltnc.JavaApp.Service.HospitalAdmission.Interface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HospitalAdmissionManageService implements IHospitalAdmissionManageService {
    @Autowired
    IGetHospitalAdmissionService getHospitalAdmissionService;
    @Autowired
    IAddHospitalAdmissionService addHospitalAdmissionService;
    @Autowired
    IUpdateHospitalAdmissionService updateHospitalAdmissionService;
    @Autowired
    IRemoveHospitalAdmissionService removeHospitalAdmissionService;


    @Override
    public void addHospitalAdmission(HospitalAdmissionDetail newHospitalAdmission, Nurse nurse) throws NullPointerException{
        try {
            this.addHospitalAdmissionService.addHospitalAdmission(newHospitalAdmission,nurse);
        }
        catch (NullPointerException e){
            throw new NullPointerException("User not found");
        }
    }

    @Override
    public void removeHospitalAdmission(String hospitalAdmissionDetailId, String modelId) throws NullPointerException {
        try {
            this.removeHospitalAdmissionService.removeHospitalAdmissionService(hospitalAdmissionDetailId,modelId);
        }
        catch (NullPointerException e){
            throw new NullPointerException("User not found");
        }
    }

    @Override
    public void updateHopitalAdmissionState(String hospitalAdmissionId, String state, LocalDate date) throws NullPointerException{

        try {
            this.updateHospitalAdmissionService.updateStateHospitalAdmissionService(
                    new PatientState(date,state),hospitalAdmissionId
            );
        }
        catch (NullPointerException e){
            throw new NullPointerException("User not found");
        }
    }

    @Override
    public List<HospitalAdmissionDetailDTO> getHospitalAdmissionDetails(String modelId) throws NullPointerException {
        try{
            return this.getHospitalAdmissionService.getHospitalAdmissions(modelId,false);
        }
        catch (NullPointerException e){
            throw new NullPointerException("User not found");
        }
    }
}
