package com.fan.springcomprehensive.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @RequestMapping(value = "/index")
    public String index() {
        return "hello world";
    }
}
