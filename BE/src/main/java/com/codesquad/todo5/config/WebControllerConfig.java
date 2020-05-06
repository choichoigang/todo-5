package com.codesquad.todo5.config;

import com.codesquad.todo5.interceptor.ActivityLoggingInterceptor;
import com.codesquad.todo5.service.ActivityService;
import com.codesquad.todo5.service.TodoService;
import com.codesquad.todo5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebControllerConfig implements WebMvcConfigurer {

  @Autowired
  private ActivityService activityService;

  @Autowired
  private TodoService todoService;

  @Autowired
  private UserService userService;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods(
            HttpMethod.GET.name(),
            HttpMethod.POST.name(),
            HttpMethod.PUT.name(),
            HttpMethod.PATCH.name(),
            HttpMethod.DELETE.name()
        );
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new ActivityLoggingInterceptor(activityService, todoService, userService))
        .addPathPatterns("/api/category/add")
        .addPathPatterns("/api/task/add")
        .addPathPatterns("/api/category/*/edit")
        .addPathPatterns("/api/task/*/edit")
        .addPathPatterns("/api/task/*/move")
        .addPathPatterns("/api/task/*/delete");
  }
}