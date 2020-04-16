package com.codesquad.todo5.interceptor;

import com.codesquad.todo5.domain.activity.Action;
import com.codesquad.todo5.domain.activity.Activity;
import com.codesquad.todo5.domain.activity.Target;
import com.codesquad.todo5.service.ActivityService;
import com.codesquad.todo5.service.TodoService;
import com.codesquad.todo5.service.UserService;
import com.codesquad.todo5.utils.JsonUtils;
import com.google.gson.JsonParser;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.web.servlet.HandlerMapping;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonElement;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ActivityLoggingInterceptor extends HandlerInterceptorAdapter {

  private final ActivityService activityService;
  private final TodoService todoService;
  private final UserService userService;

  public ActivityLoggingInterceptor(ActivityService activityService,
      TodoService todoService, UserService userService) {
    this.activityService = activityService;
    this.todoService = todoService;
    this.userService = userService;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    //TODO 현재 하드코딩으로 구현해 둔 상태이며, 로그인 기능 구현이 완료될 경우 해당 세션이나 쿠키를 활용하도록 해야 한다.
    Long userId = userService.getUserById(1L).getId();
    String userName = userService.getUserById(1L).getName();

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

  public boolean logAdd(HttpServletRequest request, Long userId, String userName) {

    if (request.getRequestURL().toString().contains("/task")) {
      Activity activity = Activity.create(userName, Action.ADD, Target.TASK);
      activity.setTargetTitle(todoService.getTaskTitleOfRecentlyAdded());
      activity.setCategoryTo((long) todoService.getTaskCategoryToOfRecentlyAdded());
      activityService.saveActivityLog(activity, userName, userId);
      return true;
    }

    if (request.getRequestURL().toString().contains("/category")) {
      Activity activity = Activity.create(userName, Action.ADD, Target.CATEGORY);
      activity.setTargetTitle(todoService.getCategoryTitleOfRecentlyAdded());
      activityService.saveActivityLog(activity, userName, userId);
      return true;
    }
    return false;
  }

  public boolean logEdit(HttpServletRequest request, Long userId, String userName) {

    if (request.getRequestURL().toString().contains("/task")) {
      Activity activity = Activity.create(userName, Action.UPDATE, Target.TASK);
      return requestSave(request, userId, userName, activity);
    }

    if (request.getRequestURL().toString().contains("/category")) {
      Activity activity = Activity.create(userName, Action.UPDATE, Target.CATEGORY);
      Map pathVariables = (Map) request
          .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
      String editedCategoryIdString = (String) pathVariables.get("id");
      Long editedCategoryId = Long.parseLong(editedCategoryIdString);
      String editedCategoryTitle = todoService.getCategoryTitleById(editedCategoryId);
      activity.setTargetTitle(editedCategoryTitle);
      return saveActivityLog(request, userId, userName, activity);
    }
    return false;
  }

  public boolean logDelete(HttpServletRequest request, Long userId, String userName) {

    if (request.getRequestURL().toString().contains("/task")) {
      Activity activity = Activity.create(userName, Action.REMOVE, Target.TASK);
      Map pathVariables = (Map) request
          .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
      String editedTaskIdString = (String) pathVariables.get("id");
      Long editedTaskId = Long.parseLong(editedTaskIdString);
      String editedTaskName = todoService.getTaskNameById(editedTaskId);
      activity.setCategoryTo(todoService.getTaskCategoryToOfDeletedTask(editedTaskId));
      activity.setTargetTitle(editedTaskName);
      return saveActivityLog(request, userId, userName, activity);
    }

    if (request.getRequestURL().toString().contains("/category")) {
      Activity activity = Activity.create(userName, Action.REMOVE, Target.CATEGORY);
      Map pathVariables = (Map) request
          .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
      String editedCategoryIdString = (String) pathVariables.get("id");
      Long editedCategoryId = Long.parseLong(editedCategoryIdString);
      String editedCategoryName = todoService.getCategoryTitleById(editedCategoryId);
      activity.setTargetTitle(editedCategoryName);
      return saveActivityLog(request, userId, userName, activity);
    }
    return false;
  }

  private boolean saveActivityLog(HttpServletRequest request, Long userId, String userName,
      Activity activity) {
    return requestSave(request, userId, userName, activity);
  }

  private boolean requestSave(HttpServletRequest request, Long userId, String userName,
      Activity activity) {
    Map pathVariables = (Map) request
        .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
    String deletedTaskIdString = (String) pathVariables.get("id");
    Long deletedTaskId = Long.parseLong(deletedTaskIdString);
    String deletedTaskTitle = todoService.getTaskNameById(deletedTaskId);
    activity.setTargetTitle(deletedTaskTitle);
    activityService.saveActivityLog(activity, userName, userId);
    return true;
  }

  public boolean logMove(HttpServletRequest request, Long userId, String userName)
      throws IOException {

    if (request.getRequestURL().toString().contains("/task")) {
      Activity activity = Activity.create(userName, Action.MOVE, Target.TASK);
      activity.setUserName(userName);

      Map pathVariables = (Map) request
          .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
      String movedTaskIdString = (String) pathVariables.get("id");
      Long movedTaskId = Long.parseLong(movedTaskIdString);
      String movedTaskTitle = todoService.getTaskNameById(movedTaskId);
      activity.setTargetTitle(movedTaskTitle);

      JsonUtils jsonUtils = new JsonUtils();
      JSONObject jObj = jsonUtils
          .readJSONStringFromRequestBody(request);
      JsonParser parser = new JsonParser();
      JsonElement element = parser.parse(String.valueOf(jObj));
      String categoryFromIdString = element.getAsJsonObject().get("categoryFrom").getAsString();
      Long categoryFromId = Long.parseLong(categoryFromIdString);
      String categoryToIdString = element.getAsJsonObject().get("categoryTo").getAsString();
      Long categoryToId = Long.parseLong(categoryToIdString);

      activity.setCategoryFrom(categoryFromId);
      activity.setCategoryTo(categoryToId);
      activityService.saveActivityLog(activity, userName, userId);
      return true;
    }
    return false;
  }
}
