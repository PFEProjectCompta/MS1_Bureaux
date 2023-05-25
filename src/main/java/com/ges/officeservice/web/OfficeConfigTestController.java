package com.ges.officeservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OfficeConfigTestController {
    @Value("${param.p1}")
    private String p1;
    @Value("${office.x}")
    private String x;


    @GetMapping("/params")
    public Map<String,String> param(){
        return Map.of("p1",p1,"x",x);
    }
}
