package com.ltnc.JavaApp;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

//@Configuration
//public class AppConfig extends AbstractMongoClientConfiguration {
//
//    @Value("${spring.data.mongodb.uri}")
//    private String uri;
//    @Value("${spring.data.mongodb.database}")
//    private String databaseName;
//    @Bean
//    public MongoClient mongoClient(){
//        return MongoClients.create(uri);
//    }
//    @Override
//    protected String getDatabaseName() {
//        return databaseName;
//    }
//
//    @Override
//    protected void configureConverters(MongoCustomConversions.MongoConverterConfigurationAdapter adapter) {
//        adapter.registerConverter(new ScheduleReadConverter());
//        adapter.registerConverter(new ScheduleWriteConverter());
//    }
//}
