package com.codesquad.todo5.utils;

import com.codesquad.todo5.domain.user.User;
import com.codesquad.todo5.exception.JwtMissingException;
import com.codesquad.todo5.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HttpInterceptor implements HandlerInterceptor {

  @Autowired
  private JwtService jwtService;

  private String secretKey = "PizzaIsBest";

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String jwtTokenString = request.getHeader("Authorization");

    if (jwtTokenString != null) {
      String token = jwtTokenString.replace("Bearer ", "");
      User user = jwtService.getTokenFromJwtString(token, secretKey);
      request.setAttribute("user", user);
      return true;
    }

    throw new JwtMissingException();
  }
}