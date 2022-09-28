package com.javatpoint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  org.springframework.beans.factory.annotation.Value;

@RestController
public class TestController {

    @Value("${Welcome.message}")
    private String checkValue;

    @GetMapping("/check")
    public String check(){
        return checkValue;
    }
}
