package com.ltnc.JavaApp;

import com.ltnc.JavaApp.Model.Schedule;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;

public class ScheduleWriteConverter implements Converter<Schedule, Document> {
    @Override
    public Document convert(Schedule source) {
        Document document = new Document();
        document.put("_id", source.getId());
        return document;
    }

}
