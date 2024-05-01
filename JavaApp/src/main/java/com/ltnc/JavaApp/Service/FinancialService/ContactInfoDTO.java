package com.ltnc.JavaApp.Service.FinancialService;

import com.ltnc.JavaApp.Model.Address;
import com.ltnc.JavaApp.Model.Patient;
import com.ltnc.JavaApp.Model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactInfoDTO {
    private String id;
    private String name;
    private String phone;
    private String gender;
    private int age;
    private Address address;
    public ContactInfoDTO(Person person){
        this.id = person.getId();
        this.name = person.getName();
        this.phone = person.getPhone();
        this.gender = person.getGender();
        this.age = person.getAge();
        this.address = person.getAddress();
    }
}
