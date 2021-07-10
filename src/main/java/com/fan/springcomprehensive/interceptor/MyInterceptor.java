package com.fan.springcomprehensive.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean result = false;
       String userId1 =  request.getParameter("userId");
       System.out.println(userId1);
       String userId = request.getHeader("userId");
       System.out.println(userId);
       if (userId.equals("001") || userId1.equals("001")) {
           result = true;
       }
        return result;
    }
}
