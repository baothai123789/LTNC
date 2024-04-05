package com.ltnc.JavaApp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



class Payload {
    private LocalDate date;
    private LocalDateTime  dateTime;
}

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping
    public Object test (@RequestBody Payload payload) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("payload", payload); // request body
        ret.put("now", new Date());
        return ret;
    }
}
