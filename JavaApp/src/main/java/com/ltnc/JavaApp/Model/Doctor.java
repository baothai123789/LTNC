package com.ltnc.JavaApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.ScheduleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Doctor")
public class Doctor extends Employee implements MedicalDetailModel, ScheduleModel {
    @Id
    private String id;
    private String major;
    @DBRef
    private List<MedicalDetail> medicalDetails;
    @DBRef
    private  List<Schedule> schedules;
    @Override
    public String getId() {return id;}
    @Override
    public void setId(String id) {this.id = id;}
    @Override
    public String getRole() {return "doctor";}
    @Override
    public void addMedicalDetail(MedicalDetail medicalDetail) {
        this.medicalDetails.add(medicalDetail);
    }
    @Override
    public List<MedicalDetail> getMedicalDetails() {
        return this.medicalDetails;
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