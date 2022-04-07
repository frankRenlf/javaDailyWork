package com.Frank.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;

@RestController
@RequestMapping(value = "")

public class TestSpringBoot {

    @RequestMapping(value = "HomePage")
    public String hello() {
        return "HomePage";
    }

}