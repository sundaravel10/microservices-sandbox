package com.example.alpha.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

public class RestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        final String token = request.getHeader("Authorization");
        if (Objects.nonNull(token) && !token.isEmpty()) {
            System.out.println("Token Value " + token);
        }else{
            System.out.println("Unauthorized");
        }
        return true;
    }
}
