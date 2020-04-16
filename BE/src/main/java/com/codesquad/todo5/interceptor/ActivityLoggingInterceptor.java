package com.codesquad.todo5.interceptor;

import com.codesquad.todo5.domain.activity.Action;
import com.codesquad.todo5.domain.activity.Activity;
import com.codesquad.todo5.domain.activity.Target;
import com.codesquad.todo5.service.ActivityService;
import com.codesquad.todo5.service.UserService;
import com.codesquad.todo5.utils.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.web.util.ContentCachingRequestWrapper;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ActivityLoggingInterceptor extends HandlerInterceptorAdapter {

  //TODO: 리팩토링 대상. 여기 인터셉터에서 스프링 의존성을 갖는 것이 이상하게 여겨진다.
  //어떨 때 @Autowired를 사용해야 하는 지도 학습한다.

  private final ActivityService activityService;
  private final UserService userService;

  public ActivityLoggingInterceptor(ActivityService activityService,
      UserService userService) {
    this.activityService = activityService;
    this.userService = userService;
  }

  Gson gson = new Gson();
  JsonParser parser = new JsonParser();

  //TODO userRepository 가져오는 부분을 하드코딩 했는데 로그인 기능이 구현되면 여기에서 로그인 인터셉터 사용해서 세션을 가져와야 한다.
  //TODO Activity의 user foreign key를 업데이트하는 로직이 필요함

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    //TODO 리팩토링하기. 아이고 진짜 안 좋다...
    Long userId = userService.getUserById(1L).getId();
    String userName = userService.getUserById(1L).getName();

    //TODO 현재 하드코딩으로 구현해 둔 상태이며, 로그인 기능 구현이 완료될 경우 해당 세션이나 쿠키를 활용하도록 해야 한다.
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
  }

  public boolean logAdd(HttpServletRequest request, Long userId, String userName)
      throws IOException {
    if (request.getRequestURL().toString().contains("/task")) {
      Activity activity = Activity.create(userName, Action.ADD, Target.TASK);
      activityService.saveActivityLog(activity, userName, userId);
      JsonUtils jsonUtils = new JsonUtils();  // 자체 정의한 jsonUtils 객체 생성
      JSONObject jObj = jsonUtils
          .readJSONStringFromRequestBody(request); // HttpServletRequest를 JSONObject 형태로 변환
      JsonElement element = JsonParser.parseString(String.valueOf(jObj));
      String title = element.getAsJsonObject().get("title").getAsString();
      System.out.println(title);
      return true;
    }
    if (request.getRequestURL().toString().contains("/category")) {
      Activity activity = Activity.create(userName, Action.ADD, Target.CATEGORY);
      activityService.saveActivityLog(activity, userName, userId);
      return true;
    }
    return false;
  }

  public boolean logEdit(HttpServletRequest request, Long userId, String userName) {
    if (request.getRequestURL().toString().contains("/task")) {
      Activity activity = Activity.create(userName, Action.UPDATE, Target.TASK);
      activityService.saveActivityLog(activity, userName, userId);
      return true;
    }
    if (request.getRequestURL().toString().contains("/category")) {
      Activity activity = Activity.create(userName, Action.UPDATE, Target.CATEGORY);
      activityService.saveActivityLog(activity, userName, userId);
      return true;
    }
    return false;
  }

  public boolean logDelete(HttpServletRequest request, Long userId, String userName) {
    if (request.getRequestURL().toString().contains("/task")) {
      Activity activity = Activity.create(userName, Action.REMOVE, Target.TASK);
      activityService.saveActivityLog(activity, userName, userId);
      return true;
    }
    if (request.getRequestURL().toString().contains("/category")) {
      Activity activity = Activity.create(userName, Action.REMOVE, Target.CATEGORY);
      activityService.saveActivityLog(activity, userName, userId);
      return true;
    }
    return false;
  }

  public boolean logMove(HttpServletRequest request, Long userId, String userName)
      throws IOException {
    if (request.getRequestURL().toString().contains("/task")) {
      Activity activity = Activity.create(userName, Action.MOVE, Target.TASK);
      activity.setUserName(userName);
      activityService.saveActivityLog(activity, userName, userId);
      String test = IOUtils.toString(request.getReader());
      System.out.println(test);
      return true;
    }
    return false;
  }
}
