package com.ltnc.JavaApp.Model;
import java.util.ArrayList;
import java.util.List;

import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.ScheduleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Patient")
public class Patient extends Person  implements MedicalDetailModel, ScheduleModel {
    @Id
    private String id;
    private List<MedicalRecord> medicalRecords=new ArrayList<>();

    @DBRef
    List<MedicalDetail> medicalDetails= new ArrayList<>();
    @DBRef
    List<Schedule> schedules= new ArrayList<>();

    @Override
    public void addMedicalDetail(MedicalDetail medicalDetail) {
        this.medicalDetails.add(medicalDetail);
    }
    @Override
    public List<MedicalDetail> getMedicalDetails() {
        return medicalDetails;
    }
    @Override
    public String getRole(){
        return "patient";
    }

    @Override
    public void addSchedule(Schedule newschedule) {
        this.schedules.add(newschedule);
    }

    @Override
    public List<Schedule> getSchedules() {
        return this.schedules;
    }

    @Override
    public void removeSchedule(String scheduleId) {
        int i = 0;
        for(Schedule schedule:schedules){
            if(schedule.getId().equals(scheduleId)){
                this.schedules.remove(i);
                break;
            }
            i++;
        }
    }
}