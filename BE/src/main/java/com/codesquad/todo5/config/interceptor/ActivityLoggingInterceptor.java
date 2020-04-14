package com.codesquad.todo5.config.interceptor;

import com.codesquad.todo5.domain.activity.Action;
import com.codesquad.todo5.domain.activity.Activity;
import com.codesquad.todo5.domain.activity.ActivityRepository;
import com.codesquad.todo5.domain.activity.Entity;
import com.codesquad.todo5.domain.task.TaskRepository;
import com.codesquad.todo5.domain.user.UserRepository;
import java.io.IOException;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ActivityLoggingInterceptor extends HandlerInterceptorAdapter {

  //TODO: 리팩토링 대상. 여기 인터셉터에서 스프링 의존성을 갖는 것이 이상하게 여겨진다.
  private final TaskRepository taskRepository;
  private final ActivityRepository activityRepository;
  private final UserRepository userRepository;

  public ActivityLoggingInterceptor(TaskRepository taskRepository,
      ActivityRepository activityRepository,
      UserRepository userRepository) {
    this.taskRepository = taskRepository;
    this.activityRepository = activityRepository;
    this.userRepository = userRepository;
  }

  //TODO userRepository 가져오는 부분을 하드코딩 했는데 로그인 기능이 구현되면 여기에서 로그인 인터셉터 사용해서 세션을 가져와야 한다.
  //TODO Activity의 user foreign key를 업데이트하는 로직이 필요함

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle)
      throws Exception {

    //TODO 리팩토링하기. 아이고 진짜 안 좋다...
    Long userId = userRepository.findById(1L).get().getId();
    String userName = userRepository.findById(1L).get().getName();

    if (request.getRequestURL().toString().contains("/add")) {
      logAdd(request, userId, userName);
    }
    if (request.getRequestURL().toString().contains("/edit")) {
      logEdit(request, userId, userName);
    }
    if (request.getRequestURL().toString().contains("/delete")) {
      logDelete(request, userId, userName);
    }
    if (request.getRequestURL().toString().contains("/move")) {
      logMove(request, userId, userName);
    }
    return false;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    super.postHandle(request, response, handler, modelAndView);
  }

  public boolean logAdd(HttpServletRequest request, Long userId, String userName) {
    if (request.getRequestURL().toString().contains("/task")) {
      // String taskId = request.getQueryString();
      // String userName = taskRepository.findUserNameByTaskId(Long.parseLong(taskId));
      Activity activity = Activity.create(userName, Action.ADD, Entity.TASK);
      activity.setUserName(userName);
      activityRepository.save(activity);
      return true;
    }
    if (request.getRequestURL().toString().contains("/category")) {
      Activity activity = Activity.create(userName, Action.ADD, Entity.CATEGORY);
      activity.setUserName(userName);
      activityRepository.save(activity);
      return true;
    }
    return false;
  }

  public boolean logEdit(HttpServletRequest request, Long userId, String userName) {
    if (request.getRequestURL().toString().contains("/task")) {
      String taskId = request.getQueryString();
      Activity activity = Activity.create(userName, Action.UPDATE, Entity.TASK);
      activity.setUserName(userName);
      activityRepository.save(activity);
      return true;
    }
    if (request.getRequestURL().toString().contains("/category")) {
      Activity activity = Activity.create(userName, Action.UPDATE, Entity.CATEGORY);
      activity.setUserName(userName);
      activityRepository.save(activity);
      return true;
    }
    return false;
  }

  public boolean logDelete(HttpServletRequest request, Long userId, String userName) {
    if (request.getRequestURL().toString().contains("/task")) {
      String taskId = request.getQueryString();
      Activity activity = Activity.create(userName, Action.REMOVE, Entity.TASK);
      activity.setUserName(userName);
      activityRepository.save(activity);
      return true;
    }
    if (request.getRequestURL().toString().contains("/category")) {
      Activity activity = Activity.create(userName, Action.REMOVE, Entity.CATEGORY);
      activity.setUserName(userName);
      activityRepository.save(activity);
      return true;
    }
    return false;
  }

  public boolean logMove(HttpServletRequest request, Long userId, String userName) throws IOException {
    if (request.getRequestURL().toString().contains("/task")) {
      String taskId = request.getQueryString();
      Activity activity = Activity.create(userName, Action.MOVE, Entity.TASK);
      activity.setUserName(userName);
      if ("POST".equalsIgnoreCase(request.getMethod()))
      {
        String test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(">>>>>>>>>>>>>>" + test);
      }
      activityRepository.save(activity);
      return true;
    }
    return false;
  }
}