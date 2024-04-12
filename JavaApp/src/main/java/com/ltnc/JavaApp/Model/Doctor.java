package com.ltnc.JavaApp.Model;

import com.ltnc.JavaApp.Service.MedicalDetailService.Interface.MedicalDetailModel;
import com.ltnc.JavaApp.Service.ScheduleService.Interface.ScheduleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private List<MedicalDetail> medicalDetails=new ArrayList<>();
    @DBRef
    private  List<Schedule> schedules=new ArrayList<>();
    @DBRef
    private NotificationList notifications;
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


    @Override
    public String getPart() {
        return "medicalEmployee";
    }
}