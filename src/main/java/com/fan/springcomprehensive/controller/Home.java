package com.fan.springcomprehensive.controller;


import com.fan.springcomprehensive.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @RequestMapping(value = "/index")
    public String index() {
        return "fan xuebig";
    }

    @GetMapping (value = "/getWriterName")
    public User getWriterName () {
        User user = new User("fanxuebing",25);
        return user;
    }
}
