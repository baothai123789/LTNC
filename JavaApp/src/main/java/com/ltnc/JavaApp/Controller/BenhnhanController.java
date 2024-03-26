package com.ltnc.JavaApp.Controller;
import com.ltnc.JavaApp.Model.Doctor;

import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Model.Doctor;
import com.ltnc.JavaApp.Repository.BenhnhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/benhnhan")
public class BenhnhanController {
    @Autowired
    BenhnhanRepository repository;
    @GetMapping("/hello")
    @ResponseBody
    public Doctor hello(){
        Doctor newbenhnhan = new Doctor(UUID.randomUUID().toString(),"my","bao");
        repository.save(newbenhnhan);
        return newbenhnhan;
    }

}
