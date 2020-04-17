package com.codesquad.todo5.utils;

import com.codesquad.todo5.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HttpInterceptor implements HandlerInterceptor {

    private final JwtService jwtService;

    Logger logger = LoggerFactory.getLogger(HttpInterceptor.class);

    public HttpInterceptor(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String jwtTokenFromCookie = jwtService.findJwtTokenFromCookie(request);
        return jwtService.isValidJwtToken(jwtTokenFromCookie);
    }
}