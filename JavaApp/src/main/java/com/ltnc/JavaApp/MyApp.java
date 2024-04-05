package com.ltnc.JavaApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import java.util.Arrays;


@SpringBootApplication


public class MyApp {

    public static final Logger LOGGER = LogManager.getLogger(MyApp.class);
    public static void main(String[] args) {
        LOGGER.debug("Debug log message");
        SpringApplication.run(MyApp.class, args);
        LOGGER.fatal("Fatal log message");
    }
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
