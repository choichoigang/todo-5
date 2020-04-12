package com.codesquad.todo5.controller;

import com.codesquad.todo5.domain.activity.Activity;
import com.codesquad.todo5.domain.user.User;
import com.codesquad.todo5.dto.activity.UserActivityResponseDto;
import com.codesquad.todo5.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/user/{userid}/activity")
  public List<UserActivityResponseDto> getUserActivityList(@PathVariable Long userid) {
    User nowUser = userService.getUserById(userid);
    List<Activity> nowUserActivities = userService.getUserActivityList(userid);
    List<UserActivityResponseDto> userActivityResponseDtoList =
        nowUserActivities.stream().map(activityitem -> new UserActivityResponseDto(activityitem, nowUser.getName())).collect(
            Collectors.toList());
    return userActivityResponseDtoList;
  }
}
