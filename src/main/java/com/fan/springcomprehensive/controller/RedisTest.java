package com.fan.springcomprehensive.controller;

import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/redis")
public class RedisTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @PostMapping(value = "/setName")
    public String setName (HttpServletRequest request) {
       String userId = request.getHeader("userId");
        String userName = request.getHeader("userName");
        if (StringUtil.isNullOrEmpty(userId) || StringUtil.isNullOrEmpty(userName)) {
            return "err";
        }
        redisTemplate.opsForValue().set(userId,userName);
        return "ok";
    }

    @GetMapping ("/getName")
    public String getName(HttpServletRequest request) {
        String userId = request.getHeader("userId");
        if (StringUtil.isNullOrEmpty(userId)) {
            return "err";
        }
        String userName = redisTemplate.opsForValue().get(userId);
        return userName;
    }
}
