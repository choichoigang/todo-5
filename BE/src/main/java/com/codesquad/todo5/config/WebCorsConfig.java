package com.codesquad.todo5.config;

import com.codesquad.todo5.config.interceptor.ActivityLoggingInterceptor;
import com.codesquad.todo5.domain.activity.ActivityRepository;
import com.codesquad.todo5.domain.task.TaskRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebCorsConfig implements WebMvcConfigurer {

  private final TaskRepository taskRepository;
  private final ActivityRepository activityRepository;

  public WebCorsConfig(TaskRepository taskRepository,
      ActivityRepository activityRepository) {
    this.taskRepository = taskRepository;
    this.activityRepository = activityRepository;
  }

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
    registry.addInterceptor(new ActivityLoggingInterceptor(taskRepository, activityRepository,
        userRepository))
        .addPathPatterns("/**");
  }
}