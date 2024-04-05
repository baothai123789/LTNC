package com.ltnc.JavaApp.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.regex.Pattern;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Certificate {
   private String department;
   private String major;

   private LocalDate time;
}
