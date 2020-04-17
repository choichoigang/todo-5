package com.codesquad.todo5.config;

import com.codesquad.todo5.service.JwtService;
import com.codesquad.todo5.utils.HttpInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer {

  private final JwtService jwtService;

  public WebMvcConfigurerImpl(JwtService jwtService) {
    this.jwtService = jwtService;
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET", "POST");
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new HttpInterceptor(jwtService))
            .addPathPatterns("/api/task/**")
            .addPathPatterns("/api/category/**")
            .addPathPatterns("/api/user/**")
            .excludePathPatterns("/api/user/auth");
  }
}
