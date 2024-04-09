package com.ltnc.JavaApp;

import com.ltnc.JavaApp.Model.Schedule;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ScheduleReadConverter implements Converter<Document, Schedule>{
    @Override
    public Schedule convert(Document source) {
        return new Schedule((String) source.get("_id"),
                ((Date)source.get("date")).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),(Integer) source.get("startTime"),
                (Integer) source.get("endTime"),(String)source.get("detail"));
    }
}
